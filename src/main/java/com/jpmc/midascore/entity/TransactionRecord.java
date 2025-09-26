package com.jpmc.midascore.entity;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
public class TransactionRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private UserRecord sender;

    @ManyToOne(fetch = FetchType.LAZY)
    private UserRecord recipient;

    @Column(nullable = false)
    private float amount;

    private Instant timestamp = Instant.now();

    protected TransactionRecord() {}

    public TransactionRecord(UserRecord sender, UserRecord recipient, float amount) {
        this.sender = sender;
        this.recipient = recipient;
        this.amount = amount;
    }

    
    public Long getId() { return id; }
    public UserRecord getSender() { return sender; }
    public void setSender(UserRecord sender) { this.sender = sender; }
    public UserRecord getRecipient() { return recipient; }
    public void setRecipient(UserRecord recipient) { this.recipient = recipient; }
    public float getAmount() { return amount; }
    public void setAmount(float amount) { this.amount = amount; }
    public Instant getTimestamp() { return timestamp; }
    public void setTimestamp(Instant timestamp) { this.timestamp = timestamp; }
}
