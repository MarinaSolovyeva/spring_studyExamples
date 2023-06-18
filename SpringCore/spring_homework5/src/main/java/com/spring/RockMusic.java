package com.spring;

import org.springframework.stereotype.Component;


public class RockMusic implements Music{

    @Override
    public String getSong() {
        return "Name of Rock Music";}

}
