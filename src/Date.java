import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Date {
    java.util.Date date;
    Train train1;
    Train train2;

    public Date(String date) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy");
        this.date = format.parse(date);
        this.train1 = new Train("trn1", "Colombo - Badulla");
        this.train2 = new Train("trn2", "Badulla - Colombo");
    }

    public Date(){

    }
    public String getDate() {
        return date.toString();
    }

    public void setDate(java.util.Date date) {
        this.date = date;
    }

    public Train getTrain1() {
        return train1;
    }

    public void setTrain1(Train train1) {
        this.train1 = train1;
    }

    public Train getTrain2() {
        return train2;
    }

    public void setTrain2(Train train2) {
        this.train2 = train2;
    }
}
