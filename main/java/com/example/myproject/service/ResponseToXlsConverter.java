package com.example.myproject.service;

import com.example.myproject.config.AjaxResponse;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;

public class ResponseToXlsConverter extends AbstractHttpMessageConverter<AjaxResponse> {
    @Override
    protected boolean supports(Class<?> aClass) {
        return (AjaxResponse.class == aClass);
    }

    @Override
    protected AjaxResponse readInternal(Class<? extends AjaxResponse> aClass, HttpInputMessage httpInputMessage) throws IOException, HttpMessageNotReadableException {
        return null;
    }

    @Override
    protected void writeInternal(AjaxResponse ajaxResponse, HttpOutputMessage httpOutputMessage) throws IOException, HttpMessageNotWritableException {

    }
}
