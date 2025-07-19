package org.example.server.pack;


import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

@Service
public class OrderService {


    @Tool(name="placeOrder", description="Place a order in the market.")
    public String placeOrder() {
        return "8=FIX.4.4|9=178|35=D|49=CLIENT123|56=BROKER456|34=5|52=20240719-10:30:45.123|11=ORD123456|15=USD|21=1|38=100|40=1|54=1|55=AAPL|59=0|60=20240719-10:30:45|10=123|";
    }

    @Tool(name="rejectOrder", description="Reject a order due to the market policy.")
    public String rejectOrder() {
        return "8=FIX.4.4|9=220|35=9|49=BROKER456|56=CLIENT123|34=7|52=20240719-11:30:15.789|11=ORD123456|37=EXCH_ORDER_ID_789|39=8|55=AAPL|54=1|58=Insufficient liquidity|434=1|10=156|";
    }

    @Tool(name="cancelOrder", description="Cancel a order due to the market policy.")
    public String cancelOrder() {
        return "8=FIX.4.4|9=167|35=F|49=CLIENT123|56=BROKER456|34=6|52=20240719-11:15:30.456|11=CANCEL12345|41=ORD123456|55=AAPL|54=1|60=20240719-11:15:30|10=234|";
    }
}
