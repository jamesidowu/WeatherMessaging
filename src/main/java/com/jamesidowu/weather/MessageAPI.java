/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jamesidowu.weather;

import com.messagebird.MessageBirdClient;
import com.messagebird.MessageBirdService;
import com.messagebird.MessageBirdServiceImpl;
import com.messagebird.exceptions.GeneralException;
import com.messagebird.exceptions.UnauthorizedException;
import com.messagebird.objects.MessageResponse;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author jamesidowu
 */
public class MessageAPI {
    
    private MessageBirdService messageBirdService;
    private MessageBirdClient messageBirdClient;
    private BigInteger phoneNumber;
    private List<BigInteger> phones;
    private MessageResponse response;
    
    
    public void getMessaging(String mobileNumber, String weatherNotification) throws UnauthorizedException, GeneralException {
     // declaring object of "OWM" class
        this.messageBirdService = new MessageBirdServiceImpl("#######");
    // Add the service to the client
        this.messageBirdClient  = new MessageBirdClient(messageBirdService);
    // convert String number into acceptable format
        phoneNumber = new BigInteger(mobileNumber);
        phones = new ArrayList<BigInteger>();
        phones.add(phoneNumber);
        response = messageBirdClient.sendMessage(mobileNumber, weatherNotification, phones);
    }
}
