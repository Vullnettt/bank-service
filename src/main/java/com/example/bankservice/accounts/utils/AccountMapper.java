package com.example.bankservice.accounts.utils;

import com.example.bankservice.accounts.AccountDto;
import com.example.bankservice.accounts.AccountEntity;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AccountMapper {

    public void mapDtoToEntity(AccountDto source, AccountEntity target) {
        if(source == null){
            return;
        }

        if(source.getId() != null){
            target.setId(source.getId());
        }
        if(source.getUsername() != null){
            target.setUsername(source.getUsername());
        }
        if(source.getAccountBalance() != null){
            target.setAccountBalance(source.getAccountBalance());
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

    public void mapEntityToDto(AccountEntity source, AccountDto target) {
        if(source == null){
            return;
        }

        if(source.getId() != null){
            target.setId(source.getId());
        }
        if(source.getUsername() != null){
            target.setUsername(source.getUsername());
        }
        if(source.getAccountBalance() != null){
            target.setAccountBalance(source.getAccountBalance());
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