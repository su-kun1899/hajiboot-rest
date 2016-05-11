package com.example.api;

import com.example.domain.Customer;
import com.example.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * コントローラ
 * <p>
 * Created by koji on 2016/05/06.
 */
@RestController
@RequestMapping("api/customers")
public class CustomerRestController {
    @Autowired
    CustomerService customerService;

    /**
     * 顧客全件取得
     *
     * @return 顧客のリスト
     */
    @RequestMapping(method = RequestMethod.GET)
    List<Customer> getCustomers() {
        List<Customer> customers = customerService.findAll();
        return customers;
    }

    /**
     * 顧客１件取得
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    Customer getCustomer(@PathVariable Integer id) {
        Customer customer = customerService.findOne(id);
        return customer;
    }

    /**
     * 顧客新規作成
     *
     * @param customer
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    Customer postCustomers(@RequestBody Customer customer) {
        return customerService.create(customer);
    }

    /**
     * 顧客１件更新
     *
     * @param id
     * @param customer
     * @return
     */
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    Customer putCustomer(@PathVariable Integer id, @RequestBody Customer customer) {
        customer.setId(id);
        return customerService.update(customer);
    }

    /**
     * 顧客一件削除
     *
     * @param id
     */
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteCustomer(@PathVariable Integer id) {
        customerService.delete(id);
    }
}
