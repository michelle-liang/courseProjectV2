package edu.itu.course.dropwizard.api.beans;

import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

import org.eclipse.jetty.servlets.EventSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.itu.course.dropwizard.sse.NotificationPublisher;


public class SseEventSource implements EventSource {

    private static final Logger LOG = LoggerFactory.getLogger(SseEventSource.class);
    
    private Emitter emitter;
    private String id;

    public SseEventSource() {
        this.id = UUID.randomUUID().toString();
    }
    @Override
    public void onOpen(Emitter emitter) throws IOException {
        LOG.info("onOpen");
        this.emitter = emitter;
    }

    @Override
    public void onClose() {
        LOG.info("onClose");
        NotificationPublisher.removeListener(this);
    }

    public void emitEvent(Manipulation msg) throws IOException {
        LOG.info("emitEvent================"+ msg.toString());
       
        this.emitter.data(msg.toString());
    }
    
    @Override
    public int hashCode() {
        return Objects.hashCode(this.id);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof SseEventSource) {
            SseEventSource that = (SseEventSource)obj;
            return Objects.equals(this.id, that.id);
        }
        return false;
    }
}