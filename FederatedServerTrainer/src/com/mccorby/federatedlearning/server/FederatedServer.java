package com.mccorby.federatedlearning.server;

import com.mccorby.federatedlearning.server.core.domain.model.FederatedModel;

import java.io.InputStream;

public interface FederatedServer {

    void registerModel(FederatedModel model);

    byte[] sendUpdatedGradient();

    void pushGradient(InputStream is);
}
