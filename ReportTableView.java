/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainproject;

/**
 *
 * @author asrock
 */
public class ReportTableView {
    String topic, content;
    public ReportTableView(String topic , String content) {
        
        this.content = content;
        this.topic = topic;
        
    }
    

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public void setContent(String content) {
        this.content = content;
    }

    

    public String getTopic() {
        return topic;
    }

    public String getContent() {
        return content;
    }

     
}

