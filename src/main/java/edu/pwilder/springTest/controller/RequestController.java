package edu.pwilder.springTest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.pwilder.springTest.model.Product;
import edu.pwilder.springTest.model.Response;
import edu.pwilder.springTest.repository.ProductDao;

@RestController
public class RequestController {

    @Autowired
    private ProductDao dao;

    @RequestMapping(path = "/addProduct", method = RequestMethod.POST)
    public Response addProduct(@RequestBody Product product) {
        dao.upsertProduct(product);
        return new Response(String.format("Product %d added!", product.getId()));
    }

    @RequestMapping("/getProduct")
    public Product getProduct(@RequestParam int id) {
        return dao.getProductById(id);
    }
}
