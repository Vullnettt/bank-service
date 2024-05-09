package com.example.bankservice.transactions.utils;

import com.example.bankservice.transactions.TransactionDto;
import com.example.bankservice.transactions.TransactionEntity;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TransactionMapper {

    public void mapDtoToEntity(TransactionDto source, TransactionEntity target) {
        if(source == null){
            return;
        }

        if(source.getId() != null){
            target.setId(source.getId());
        }
        if(source.getAmount() != null){
            target.setAmount(source.getAmount());
        }
        if(source.getOriginatingAccountId() != null){
            target.setOriginatingAccountId(source.getOriginatingAccountId());
        }
        if(source.getResultingAccountId() != null){
            target.setResultingAccountId(source.getResultingAccountId());
        }
        if(source.getTransactionReason() != null){
            target.setTransactionReason(source.getTransactionReason());
        }
        if (source.getCreatedAt() != null) {
            target.setCreatedAt(source.getCreatedAt());
        }
        if (source.getCreatedBy() != null) {
            target.setCreatedBy(source.getCreatedBy());
        }
        if (source.getUpdatedAt() != null) {
            target.setUpdatedAt(source.getUpdatedAt());
        }
        if (source.getUpdatedBy() != null) {
            target.setUpdatedBy(source.getUpdatedBy());
        }
        if (source.getDeletedAt() != null) {
            target.setDeletedAt(source.getDeletedAt());
        }
        if (source.getDeletedBy() != null) {
            target.setDeletedBy(source.getDeletedBy());
        }
    }

    public void mapEntityToDto(TransactionEntity source, TransactionDto target) {
        if(source == null){
            return;
        }

        if(source.getId() != null){
            target.setId(source.getId());
        }
        if(source.getAmount() != null){
            target.setAmount(source.getAmount());
        }
        if(source.getOriginatingAccountId() != null){
            target.setOriginatingAccountId(source.getOriginatingAccountId());
        }
        if(source.getResultingAccountId() != null){
            target.setResultingAccountId(source.getResultingAccountId());
        }
        if(source.getTransactionReason() != null){
            target.setTransactionReason(source.getTransactionReason());
        }
        if (source.getCreatedAt() != null) {
            target.setCreatedAt(source.getCreatedAt());
        }
        if (source.getCreatedBy() != null) {
            target.setCreatedBy(source.getCreatedBy());
        }
        if (source.getUpdatedAt() != null) {
            target.setUpdatedAt(source.getUpdatedAt());
        }
        if (source.getUpdatedBy() != null) {
            target.setUpdatedBy(source.getUpdatedBy());
        }
        if (source.getDeletedAt() != null) {
            target.setDeletedAt(source.getDeletedAt());
        }
        if (source.getDeletedBy() != null) {
            target.setDeletedBy(source.getDeletedBy());
        }
    }
}
