package org.example.service;

import com.alibaba.fastjson.JSONObject;
import io.seata.common.util.CollectionUtils;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.example.dao.OrderDao;
import org.example.entities.Order;
import org.example.handler.ServiceException;
import org.example.model.CommonResult;
import org.example.model.OrderRequest;
import org.example.model.OrderResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;

    @Resource
    private AccountService accountService;

    @Resource
    private StorageService storageService;

    @Override
    @GlobalTransactional(name = "create-order", rollbackFor = Exception.class)
    public void create(OrderRequest orderRequest) {
        Long productId = orderRequest.getProductId();
        Integer count = orderRequest.getCount();
        CommonResult commonResult = storageService.getById(productId);
        if (Optional.ofNullable(commonResult).isPresent() && commonResult.getCode() == 200) {
            JSONObject object = (JSONObject) JSONObject.toJSON(commonResult.getData());
            BigDecimal price = object.getBigDecimal("price");
            if (Optional.ofNullable(price).isPresent()) {
                Long userId = getUserId();
                BigDecimal number = new BigDecimal(count);
                Order order = new Order();
                BeanUtils.copyProperties(orderRequest, order);
                order.setUserId(userId);
                order.setMoney(price.multiply(number));
                order.setCreateTime(new Date());
                log.info("create order");
                orderDao.save(order);
                log.info("decrease storage");
                storageService.decrease(productId, count);
                log.info("decrease account");
                accountService.decrease(userId, order.getMoney());
                log.info("update order status");
                orderDao.updateStatus(order.getId(), userId, 1, 0);
                log.info("done");
                return;
            }
        }
        throw new ServiceException(400, "product not exists");
    }

    // 获取用户ID
    private Long getUserId() {
        return 1l;
    }

    @Override
    public OrderResponse get(Long id) {
        Order order = orderDao.getById(id);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        OrderResponse orderResponse = new OrderResponse();
        BeanUtils.copyProperties(order, orderResponse);
        orderResponse.setCreateTime(format.format(order.getCreateTime()));
        orderResponse.setUpdateTime(format.format(order.getUpdateTime()));
        return orderResponse;
    }

    @Override
    public List<OrderResponse> list() {
        Long userId = getUserId();
        List<Order> orders = orderDao.getByUserId(userId);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (CollectionUtils.isNotEmpty(orders)) {
            return orders.stream().map(o -> {
                OrderResponse orderResponse = new OrderResponse();
                BeanUtils.copyProperties(o, orderResponse);
                orderResponse.setCreateTime(format.format(o.getCreateTime()));
                orderResponse.setUpdateTime(format.format(o.getUpdateTime()));
                return orderResponse;
            }).collect(Collectors.toList());
        }
        return Collections.EMPTY_LIST;
    }
}
