package et.android.fremote;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.jivesoftware.smack.Chat;
import org.jivesoftware.smack.ChatManager;
import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.MessageListener;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.Presence;
import org.xml.sax.SAXException;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.TextView;

public class FarruscoRemote extends Activity implements SensorEventListener {
    
	TextView txt;
	TextView ctxt;
	private float x, y, z;
	private long lastUpdate = -1;
	private long tbLastUpdate = -1;
	XMPPConnection connection;
	ChatManager chatmanager;
	Chat chat;
	String cmd;
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        
    	super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        cmd="";
        
        txt=(TextView)findViewById(R.id.txt);
        ctxt=(TextView)findViewById(R.id.ctxt);
        
        SensorManager sm = (SensorManager)getSystemService(SENSOR_SERVICE);
        
        List<Sensor> sl = sm.getSensorList(Sensor.TYPE_ACCELEROMETER);
        
        boolean sensorSupported = sm.registerListener(this, sl.get(0), sm.SENSOR_DELAY_UI);
         if (!sensorSupported) {
        // on accelerometer on this device
        	 sm.unregisterListener((SensorEventListener)this, sl.get(0));
         }
         
         ConnectionConfiguration connConf = new ConnectionConfiguration("talk.google.com", 5222, "gmail.com");
 		connection = new XMPPConnection(connConf);
 	
 		connect();
 		
         
         
    }
  
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
    	if (tbLastUpdate == -1 || (System.currentTimeMillis() - tbLastUpdate) > 100) {
            
	    	String ctext = "";
	    	switch(keyCode){
	    	case KeyEvent.KEYCODE_DPAD_DOWN:{
    			ctext="D";
    			sendXmppMessage("D");

	    		break;
	    	}
	    	case KeyEvent.KEYCODE_DPAD_UP:{
    			ctext="A";
    			sendXmppMessage("A");

	    		break;
	    	}
	    	case KeyEvent.KEYCODE_DPAD_LEFT:{
    			ctext="W";
    			sendXmppMessage("W");

	    		break;
	    	}
	    	case KeyEvent.KEYCODE_DPAD_RIGHT:{
	    		ctext="Q";
	    		sendXmppMessage("Q");

				break;
	    	}
	    	}
	    	ctxt.setText(ctext);
	    	
    	}
    	return true;
    }
  





	public void onAccuracyChanged(Sensor arg0, int arg1) {
		
		
	}








	public void onSensorChanged(SensorEvent event) {
		if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            long curTime = System.currentTimeMillis();
            // only allow one update every 100ms, otherwise updates
            // come way too fast and the phone gets bogged down
            // with garbage collection
            if (lastUpdate == -1 || (curTime - lastUpdate) > 3000) {
                lastUpdate = curTime;

                x = event.values[0];
                y = event.values[1];
                z = event.values[2];
                
                String text = "stop";
                boolean cmdSent = false;
                if(z>3){
                	cmdSent=true;
                	sendXmppMessage("F");
                	text ="F";

                } 
                if(z<-3){
                	cmdSent=true;
                	sendXmppMessage("B");
                	text ="B";
                } 
                
                if(y>2){
                	cmdSent=true;
                	sendXmppMessage("L");
                	text ="L";
                }
                
                if(y<-2){
                	cmdSent=true;
                	sendXmppMessage("R");
                	text ="R";
                } 
                
                if(!cmdSent){
                	cmdSent=true;
                	sendXmppMessage("S");
                	text ="S";
                }
                
                txt.setText(text);
                //txt.setText(String.format("X: %+2.5f | Y: %+2.5f | Z: %+2.5f ", x, y, z));
            }
        }
	}
	
	public void connect(){
			boolean bError=false;
			try {
				connection.connect();
			} catch (XMPPException e) {
				Log.e("XMPP", e.getMessage());
				bError = true;
			}
			if(!bError){
				//authentication
				try{
						this.connection.login("n.d.santos1@gmail.com", "ns171284");
				} catch(XMPPException e){
					//show wContact google account form
					
					
					Log.e("XMPP", e.getMessage());
					bError = true;
				}
			}
			if(!bError){
					
					
				//set presence status
				Presence presence = new Presence(Presence.Type.available);
				this.connection.sendPacket(presence);
				
				//set listener
				chatmanager = connection.getChatManager();
				this.chat = chatmanager.createChat("farruscorobot@gmail.com", new MessageListener() {
					
					Handler handler = new Handler(){
						public void handleMessage(android.os.Message message) {
							
								Log.i("XMPP", message.getData().getString("MSG"));
						};
					};

					public void processMessage(Chat arg0, Message message) {
							/*//handler
							android.os.Message msgHandler = new android.os.Message();
								
							if(message!=null){
							
							Bundle bundle = new Bundle();
							bundle.putString("MSG", message.getBody());
							msgHandler.setData(bundle);
								
							}
							*/	
							
						
						
						
					}
					
				});
				
				
					
					
					
			}
		}
	
	public void sendXmppMessage(String xmsg){
		if(!cmd.equals(xmsg)){
			
			
			
			Message msg = new Message("farruscorobot@gmail.com");
			msg.setBody(xmsg);
			cmd=xmsg;
			try {
				chat.sendMessage(msg);
			} catch (XMPPException e) {
				Log.e("XMPP", e.getMessage());
			}
		}
		
		ctxt.setText(xmsg);
	}
}