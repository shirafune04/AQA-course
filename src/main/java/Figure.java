interface Figure {
    String getFillColor();
    String getBorderColor();

    default double perimeter() { return 0; }
    default double area() { return 0; }

    default void printInfo() {
        System.out.println("Периметр: " + perimeter());
        System.out.println("Площадь: " + area());
        System.out.println("Цвет заливки: " + getFillColor());
        System.out.println("Цвет границы: " + getBorderColor());
        System.out.println("-------------------");
    }
}

class Circle implements Figure {
    double r;
    String fillColor;
    String borderColor;

    public Circle(double r, String fillColor, String borderColor) {
        this.r = r;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public double perimeter() { return 2 * Math.PI * r; }

    @Override
    public double area() { return Math.PI * r * r; }

    @Override
    public String getFillColor() { return fillColor; }

    @Override
    public String getBorderColor() { return borderColor; }
}

class Rectangle implements Figure {
    double width, height;
    String fillColor, borderColor;

    public Rectangle(double width, double height, String fillColor, String borderColor) {
        this.width = width;
        this.height = height;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public double perimeter() { return 2 * (width + height); }

    @Override
    public double area() { return width * height; }

    @Override
    public String getFillColor() { return fillColor; }

    @Override
    public String getBorderColor() { return borderColor; }
}

class Triangle implements Figure {
    double sideA, sideB, sideC;
    String fillColor, borderColor;

    public Triangle(double sideA, double sideB, double sideC, String fillColor, String borderColor) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public double perimeter() { return sideA + sideB + sideC; }

    @Override
    public double area() {
        double p = perimeter() / 2;
        return Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
    }

    @Override
    public String getFillColor() { return fillColor; }

    @Override
    public String getBorderColor() { return borderColor; }
}

class Main {
    public static void main(String[] args) {
        Figure[] figures = {
                new Circle(6, "Зелёный", "Жёлтый"),
                new Rectangle(5, 7, "Красный", "Синий"),
                new Triangle(5, 6, 7, "Розовый", "Фиолетовый")
        };

        for (Figure f : figures) {
            f.printInfo();
        }
    }
}