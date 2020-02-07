package netology;

import com.github.javafaker.Faker;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


public class Data {


    public static long methodTimestamp(int days) {
        Date currentDate = new Date();

        Calendar c = Calendar.getInstance();
        c.setTime(currentDate);
        c.add(Calendar.DATE, days);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);

        Date extendedDate = c.getTime();
        return extendedDate.getTime();
    }

    public static class Registration {
        private Registration() {
        }

        public static RegCardInfo generateByCard(String locale) {
            Faker faker = new Faker(new Locale(locale));
            return new RegCardInfo(faker.address().city(),
                    faker.name().fullName(),
                    faker.phoneNumber().phoneNumber());
        }
    }
}
