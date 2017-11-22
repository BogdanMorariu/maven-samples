package com.bm.repository;

import java.util.function.Supplier;

public enum RepositorySupplierPrimitive implements Supplier<InMemoryRepositoryPrimitive>{

    KOLOBOKE_PRIMITIVE_MAP(){
        @Override
        public InMemoryRepositoryPrimitive get() { return new KolobokeBasedRepositoryPrimitive(); }
    }
}
