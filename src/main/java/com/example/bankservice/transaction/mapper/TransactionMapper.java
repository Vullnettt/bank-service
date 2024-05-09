package com.example.bankservice.transaction.mapper;

import com.example.bankservice.transaction.TransactionEntity;
import com.example.bankservice.transaction.TransactionDto;
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
        if(source.getAmount() > 0){
            target.setAmount(source.getAmount());
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
        if(source.getAmount() > 0){
            target.setAmount(source.getAmount());
        }
        if(source.getOriginatingAccountEntity() != null){
            target.setOriginatingAccountId(source.getOriginatingAccountEntity().getId());
        }
        if(source.getResultingAccountEntity() != null){
            target.setResultingAccountId(source.getResultingAccountEntity().getId());
        }
        if(source.getTransactionReason() != null){
            target.setTransactionReason(source.getTransactionReason());
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
