package com.example.bankservice.banks.utils;

import com.example.bankservice.banks.BankDto;
import com.example.bankservice.banks.BankEntity;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BankMapper {

    public void mapDtoToEntity(BankDto source, BankEntity target) {
        if(source == null){
            return;
        }

        if(source.getId() != null){
            target.setId(source.getId());
        }
        if(source.getTotalTransactionFee() != null){
            target.setTotalTransactionFee(source.getTotalTransactionFee());
        }
        if(source.getTotalTransactionAmount() != null){
            target.setTotalTransactionAmount(source.getTotalTransactionAmount());
        }
        if(source.getTransactionFlatFee() != null){
            target.setTransactionFlatFee(source.getTransactionFlatFee());
        }
        if(source.getTransactionPercentFee() != null){
            target.setTransactionPercentFee(source.getTransactionPercentFee());
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

    public void mapEntityToDto(BankEntity source, BankDto target) {
        if(source == null){
            return;
        }

        if(source.getId() != null){
            target.setId(source.getId());
        }
        if(source.getTotalTransactionFee() != null){
            target.setTotalTransactionFee(source.getTotalTransactionFee());
        }
        if(source.getTotalTransactionAmount() != null){
            target.setTotalTransactionAmount(source.getTotalTransactionAmount());
        }
        if(source.getTransactionFlatFee() != null){
            target.setTransactionFlatFee(source.getTransactionFlatFee());
        }
        if(source.getTransactionPercentFee() != null){
            target.setTransactionPercentFee(source.getTransactionPercentFee());
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
