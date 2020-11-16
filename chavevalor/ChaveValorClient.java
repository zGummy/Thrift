import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

public class ChaveValorClient {
  public static void main(String [] args) {

   
    try {
      TTransport transport;
     
      transport = new TSocket("localhost", 9090);
      transport.open();

      TProtocol protocol = new  TBinaryProtocol(transport);
      ChaveValor.Client client = new ChaveValor.Client(protocol);

      perform(client,1,"Carlos");
      perform(client,1,"Lasaro");
      perform(client,1,"Coelho");

      transport.close();
    } catch (TException x) {
      x.printStackTrace();
    } 
  }

  private static void perform(ChaveValor.Client client,int key, String value) throws TException
  {
   
    string antValue = client.setKV(key,value);
    System.out.println("Valor anterior=" + antValue);
  }
}