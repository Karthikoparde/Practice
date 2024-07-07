package com.wipro.bus.service;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

import jakarta.annotation.PostConstruct;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class PaymentService {

    private RazorpayClient razorpayClient;

    @Value("${razorpay.keyId}")
    private String keyId;

    @Value("${razorpay.keySecret}")
    private String keySecret;

    @PostConstruct
    public void init() throws RazorpayException {
        this.razorpayClient = new RazorpayClient(keyId, keySecret);
    }

    public Order createOrder(int amount, String currency) throws RazorpayException {
        JSONObject orderRequest = new JSONObject();
        orderRequest.put("amount", amount * 100); // amount in paise
        orderRequest.put("currency", currency);
        orderRequest.put("payment_capture", 1); // auto capture

        return razorpayClient.orders.create(orderRequest);
    }

    // Add more methods to verify payment and handle payment events if necessary
}
