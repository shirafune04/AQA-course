class Animal {
    protected String name;
    static int animalCount = 0;

    Animal(String name) {
        this.name = name;
        animalCount++;
    }

    void run(int distance) {}
    void swim(int distance) {}
}

class Dog extends Animal {
    static int dogCount = 0;

    Dog(String name) {
        super(name);
        dogCount++;
    }

    void run(int distance) {
        if (distance <= 500) {
            System.out.println(name + " пробежал " + distance + " м.");
        } else {
            System.out.println(name + " не может пробежать больше 500 м.");
        }
    }

    void swim(int distance) {
        if (distance <= 10) {
            System.out.println(name + " проплыл " + distance + " м.");
        } else {
            System.out.println(name + " не может проплыть больше 10 м.");
        }
    }
}

class Bowl {
    int food = 0;

    Bowl(int food) {
        this.food = Math.max(food, 0);
    }

    boolean enough(int a) {
        return food >= a;
    }

    void take(int a) {
        if (enough(a)) food -= a;
    }

    void addFood(int a) {
        if (a > 0) {
            food += a;
            System.out.println("Добавили " + a + " еды. Теперь: " + food);
        }
    }
}

class Cat extends Animal {
    static int catCount = 0;
    private final int appetite;
    boolean full = false;

    Cat(String name, int appetite) {
        super(name);
        this.appetite = appetite;
        catCount++;
    }

    void run(int distance) {
        if (distance <= 200) {
            System.out.println(name + " пробежал " + distance + " м.");
        } else {
            System.out.println(name + " не может пробежать больше 200 м.");
        }
    }

    void swim(int distance) {
        System.out.println(name + " не умеет плавать");
    }

    void eat(Bowl bowl) {
        if (bowl.food >= appetite) {
            bowl.food -= appetite;
            this.full = true;
            System.out.println(name + " поел. Съел " + appetite);
        } else {
            System.out.println(name + " — мало еды! Нужно " + appetite + ", в миске " + bowl.food);
        }
    }
}

class Main {
    public static void main(String[] args) {

        new Dog("Бобик").run(150);
        new Dog("Бобик").run(600);
        new Dog("Бобик").swim(5);
        new Cat("Барсик", 10).run(100);
        new Cat("Барсик", 15).swim(10);

        System.out.println("\nЖивотных: " + Animal.animalCount + "\nСобак: " + Dog.dogCount + "\nКотов: " + Cat.catCount);

        Bowl bowl = new Bowl(20);
        System.out.println("\nВ миске: " + bowl.food);

        Cat[] cats = {
                new Cat("Барсик", 5),
                new Cat("Мурзик", 20),
                new Cat("Снежок", 15),
        };

        for (Cat c : cats) c.eat(bowl);

        System.out.println("\nСытость:");
        for (Cat c : cats) {System.out.println(c.name + ": " + (c.full ? "✅" : "❌"));
        }

        bowl.addFood(10);
        System.out.println("В миске теперь: " + bowl.food);

        for (Cat c : cats) {
            if (!c.full) c.eat(bowl);
        }

        System.out.println("\nИтог:");
        for (Cat c : cats) System.out.println(c.name + ": " + (c.full ? "✅" : "❌"));
        System.out.println("В миске: " + bowl.food);
    }
}
