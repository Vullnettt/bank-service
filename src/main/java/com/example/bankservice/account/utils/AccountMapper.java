package com.example.bankservice.account.utils;
import com.example.bankservice.account.AccountEntity;
import com.example.bankservice.account.AccountDto;
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
        if(source.getName() != null){
            target.setName(source.getName());
        }
        if(source.getBalance() > 0){
            target.setBalance(source.getBalance());
        }
        if(source.getOutgoingTransactions() != null){
            target.setOutgoingTransactions(source.getOutgoingTransactions());
        }
        if(source.getIncomingTransactions() != null){
            target.setIncomingTransactions(source.getIncomingTransactions());
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
        if(source.getName() != null){
            target.setName(source.getName());
        }
        if(source.getBalance() > 0){
            target.setBalance(source.getBalance());
        }
        if(source.getBank() != null){
            target.setBankId(source.getBank().getId());
        }
        if(source.getOutgoingTransactions() != null){
            target.setOutgoingTransactions(source.getOutgoingTransactions());
        }
        if(source.getIncomingTransactions() != null){
            target.setIncomingTransactions(source.getIncomingTransactions());
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
