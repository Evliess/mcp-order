package org.example.server;

import org.example.server.pack.OrderService;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ServerApp {
    public static void main(String[] args) {
        SpringApplication.run(ServerApp.class, args);
    }


    @Bean
    public ToolCallbackProvider weatherTools(OrderService orderService) {
        return MethodToolCallbackProvider.builder().toolObjects(orderService).build();
    }
}
