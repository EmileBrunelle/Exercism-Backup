class Darts {
    int score(double xOfDart, double yOfDart) {
        var distance = Math.sqrt(Math.pow(xOfDart, 2) + Math.pow(yOfDart, 2));

        int points;

        if (distance <= 1) {
            points = 10;
        } else if (distance <= 5) {
            points = 5;
        } else if (distance <= 10) {
            points = 1;
        } else {
            points = 0;
        }

        return points;
    }
}
