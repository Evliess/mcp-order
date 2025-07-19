package org.example.client;

import io.modelcontextprotocol.client.McpClient;
import io.modelcontextprotocol.client.transport.ServerParameters;
import io.modelcontextprotocol.client.transport.StdioClientTransport;
import io.modelcontextprotocol.spec.McpSchema;

import java.util.Map;

public class ClientApp {

    public static void main(String[] args) {
        var stdioParams = ServerParameters.builder("java")
                .args("-jar", "C:\\Users\\xiaofei\\Desktop\\mcp\\mcp-order-1.0-SNAPSHOT.jar")
                .build();
        var stdioTransport = new StdioClientTransport(stdioParams);

        var mcpClient = McpClient.sync(stdioTransport).build();

        mcpClient.initialize();

        McpSchema.ListToolsResult toolsList = mcpClient.listTools();

        McpSchema.CallToolResult placeOrder = mcpClient.callTool(
                new McpSchema.CallToolRequest("placeOrder",
                        Map.of("", "")));
        System.out.println(placeOrder.content().get(0));

        McpSchema.CallToolResult cancelOrder = mcpClient.callTool(
                new McpSchema.CallToolRequest("cancelOrder", Map.of("", "")));
        System.out.println(cancelOrder.content().get(0));
        mcpClient.closeGracefully();
    }
}
