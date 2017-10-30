package com.bm.repository;

import com.bm.model.Order;
import java.util.function.Supplier;

//TODO WHY DOES THIS WORK ?!?!
public enum RepositorySupplier implements Supplier<InMemoryRepository<Order>> {
    HASH_SET() {
        @Override
        public InMemoryRepository<Order> get() {
            return new HashSetBasedRepository<>();
        }
    },

    TREE_SET() {
        @Override
        public InMemoryRepository<Order> get() {
            return new TreeSetBasedRepository<>();
        }
    },

    ARRAY_LIST() {
        @Override
        public InMemoryRepository<Order> get() {
            return new ArrayListBasedRepository<>();
        }
    },

    CONCURRENT_HASH_MAP() {
        @Override
        public InMemoryRepository<Order> get() {
            return new ConcurrentHashMapBasedRepository<>();
        }
    },

    KOLOBOKE_MAP(){
        @Override
        public InMemoryRepository<Order> get() { return new KolobokeBasedRepository<>(); }
    },

    GS_COLLECTIONS_MAP(){
        @Override
        public InMemoryRepository<Order> get(){ return new GSMapBasedRepostiory<>(); }
    }



}
