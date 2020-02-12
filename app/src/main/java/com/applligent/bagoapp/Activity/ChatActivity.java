package com.applligent.bagoapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.applligent.bagoapp.Fragment.ChatFragment;
import com.applligent.bagoapp.Fragment.ChatlistFragment;
import com.applligent.bagoapp.R;

import co.intentservice.chatui.ChatView;
import co.intentservice.chatui.models.ChatMessage;
import de.hdodenhof.circleimageview.CircleImageView;

public class ChatActivity extends AppCompatActivity {

    CircleImageView circleImageView;
    TextView name,msg,status;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        circleImageView=findViewById(R.id.image);
        name=findViewById(R.id.name);
        msg=findViewById(R.id.msg);
        status=findViewById(R.id.status);

        intent=getIntent();
        name.setText(intent.getStringExtra("name"));
        circleImageView.setImageResource(intent.getIntExtra("photo",0));
        msg.setText("2.7k Messages");
        status.setText("Online");

        ChatView chatView = (ChatView) findViewById(R.id.chat_view);

        chatView.setOnSentMessageListener(new ChatView.OnSentMessageListener(){
            @Override
            public boolean sendMessage(ChatMessage chatMessage){
                // perform actual message sending
                return true;
            }
        });

        chatView.setTypingListener(new ChatView.TypingListener(){
            @Override
            public void userStartedTyping(){
                // will be called when the user starts typing
            }

            @Override
            public void userStoppedTyping(){
                // will be called when the user stops typing
            }
        });
    }
}
