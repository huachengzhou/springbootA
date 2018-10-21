package com.yiibai.demo.controller;

import com.yiibai.demo.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author zch
 * @Description
 * @createDate 2018/10/21
 **/
@RestController
public class ProductServiceController {
    private Logger logger = LoggerFactory.getLogger(getClass());
    private static Map<String, Product> productRepo = new HashMap<>();

    static {
        Product honey = new Product();
        honey.setId("1");
        honey.setName("Honey");
        productRepo.put(honey.getId(), honey);

        Product almond = new Product();
        almond.setId("2");
        almond.setName("Almond");
        productRepo.put(almond.getId(), almond);
    }

    @RequestMapping(value = "/products/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@PathVariable("id") String id) {
        logger.info(String.format("%s",id));
        logger.info("delete");
        productRepo.remove(id);
        return new ResponseEntity<>("Product is deleted successsfully", HttpStatus.OK);
    }

    @RequestMapping(value = "/products/put/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateProduct(@PathVariable("id") String id, @RequestBody Product product) {
        logger.info("put");
        logger.info(String.format("%s",id));
        logger.info(String.format("%s",product));
        productRepo.remove(id);
        product.setId(id);
        productRepo.put(id, product);
        return new ResponseEntity<>("Product is updated successsfully", HttpStatus.OK);
    }

    @RequestMapping(value = "/products/post", method = RequestMethod.POST)
    public ResponseEntity<Object> createProduct(@RequestBody Product product) {
        logger.info("post");
        productRepo.put(product.getId(), product);
        logger.info(String.format("%s",product));
        return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/products/get")
    public ResponseEntity<Object> getProduct() {
        logger.info("get");
        logger.info(String.format("%s",productRepo.values()));
        return new ResponseEntity<>(productRepo.values(), HttpStatus.OK);
    }

}
