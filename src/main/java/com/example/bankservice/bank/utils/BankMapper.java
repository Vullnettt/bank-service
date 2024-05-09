package com.example.bankservice.bank.utils;

import com.example.bankservice.bank.Bank;
import com.example.bankservice.bank.BankDto;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BankMapper {

    public void mapDtoToEntity(BankDto source, Bank target) {
        if(source == null){
            return;
        }

        if(source.getId() != null){
            target.setId(source.getId());
        }
        if(source.getName() != null){
            target.setName(source.getName());
        }
        if(source.getAccountEntities() != null){
            target.setAccounts(source.getAccountEntities());
        }
        if(source.getTotalTransactionFeeAmount() > 0){
            target.setTransactionFlatFeeAmount(source.getTotalTransactionFeeAmount());
        }
        if(source.getTotalTransferAmount() > 0){
            target.setTotalTransferAmount(source.getTotalTransferAmount());
        }
        if(source.getTransactionFlatFeeAmount() > 0){
            target.setTransactionFlatFeeAmount(source.getTransactionFlatFeeAmount());
        }
        if(source.getTransactionPercentFeeValue() > 0){
            target.setTransactionPercentFeeValue(source.getTransactionPercentFeeValue());
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

    public void mapEntityToDto(Bank source, BankDto target) {
        if(source == null){
            return;
        }

        if(source.getId() != null){
            target.setId(source.getId());
        }
        if(source.getName() != null){
            target.setName(source.getName());
        }
        if(source.getAccounts() != null){
            target.setAccountEntities(source.getAccounts());
        }
        if(source.getTotalTransactionFeeAmount() > 0){
            target.setTransactionFlatFeeAmount(source.getTotalTransactionFeeAmount());
        }
        if(source.getTotalTransferAmount() > 0){
            target.setTotalTransferAmount(source.getTotalTransferAmount());
        }
        if(source.getTransactionFlatFeeAmount() > 0){
            target.setTransactionFlatFeeAmount(source.getTransactionFlatFeeAmount());
        }
        if(source.getTransactionPercentFeeValue() > 0){
            target.setTransactionPercentFeeValue(source.getTransactionPercentFeeValue());
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
