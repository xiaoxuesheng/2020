package 订单取消场景_RabbitMq;

@Component
@Slf4j
public class MQReceiver {
    @RabbitListener(queues = MQConfig.DELAY_QUEUE)
    @RabbitHandler
    public void onDelayMessage(Message msg, Channel channel) throws IOException {
        long deliveryTag = msg.getMessageProperties().getDeliveryTag();
        channel.basicAck(deliveryTag, true);
        System.out.println("延迟队列在" + LocalDateTime.now()+"时间," + "延迟后收到消息:" + new String(msg.getBody()));
    }
}
