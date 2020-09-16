package org.yiming.networkworkbench.example.service.impl;

import org.yiming.networkworkbench.example.service.ExampleService;
import org.yiming.networkworkbench.framework.beans.annotation.Service;


@Service
public class ExampleServiceImpl implements ExampleService {
    @Override
    public String example(String parameter) {
        return parameter;
    }
}
