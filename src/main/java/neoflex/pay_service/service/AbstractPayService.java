package neoflex.pay_service.service;

import lombok.extern.slf4j.Slf4j;

import java.util.function.Supplier;

@Slf4j
public class AbstractPayService<T> {

    protected T calculatePay(Supplier<T> supplier) {
        T t = supplier.get();
        log.info("Successful payment calculation: {}", t);
        return t;
    }
}
