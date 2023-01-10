
class Clock {

    int hours = 12;
    int minutes = 0;

    void next() {
        // implement me
        if (this.minutes == 59) {
            this.minutes = 0;
            this.hours += 1;
            if (this.hours == 13) {
                this.hours = 1;
            }
            return;
        }
        minutes += 1;
    }
}