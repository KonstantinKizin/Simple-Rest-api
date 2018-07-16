package by.kizin.konstantin.resttask.service.client.command;

import java.util.function.Function;

public interface MyFunction<T,R>  {

    R apply(T t) throws Exception;
}
