package com.yonder.exercise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExerciseApplication {

  interface A {

  }

  interface B {

  }

  interface C {

  }

  interface AFactory {

    A create();
  }

  interface BFactory {

    B create();
  }

  interface CFactory {

    C create();
  }

  class AImpl implements A {

  }

  class BImpl implements B {

  }

  class CImpl implements C {

    private A a;
    private B b;

    public CImpl(A a, B b) {
      this.a = a;
      this.b = b;
    }
  }

  class AFactoryImpl implements AFactory {

    @Override
    public A create() {
      return new AImpl();
    }
  }

  class BFactoryImpl implements BFactory {

    @Override
    public B create() {
      return new BImpl();
    }
  }

  class CFactoryImpl implements CFactory {

    AFactory aFactory;
    BFactory bFactory;

    public CFactoryImpl(AFactory aFactory, BFactory bFactory) {
      this.aFactory = aFactory;
      this.bFactory = bFactory;
    }

    @Override
    public C create() {
      return new CImpl(aFactory.create(), bFactory.create());
    }
  }

  public void aaa() {
    DIContainer container = new DIContainer();
    C c = new CFactoryImpl(container.getAFactory("AFactoryImpl"), container.getBFactory("BFactoryImpl")).create();
  }

  class DIContainer {
    public AFactory getAFactory(String type) {
      if (type.equals("AFactoryImpl")) {
        return new AFactoryImpl();
      } else {
        return null;
      }
    }

    public BFactory getBFactory(String type) {
      if (type.equals("BFactoryImpl")) {
        return new BFactoryImpl();
      } else {
        return null;
      }
    }
  }


  public static void main(String[] args) {
    SpringApplication.run(ExerciseApplication.class, args);
  }
}
