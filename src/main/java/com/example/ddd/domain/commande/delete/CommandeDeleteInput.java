package com.example.ddd.domain.commande.delete;

import com.example.ddd.domain.core.AbstractProcessInput;

public class CommandeDeleteInput extends AbstractProcessInput {
    String reference;

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

}
