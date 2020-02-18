import java.io.Serializable;
import java.util.Objects;

// Serializable - интерфейс-марка для сериализации обьектов
// Если не указать то будет ошибка NotSerializableException
public class User implements Serializable {
    // transient - указывает, что поле не сериализуемо!!!
    transient int liveLevel;
    // статическое поле не сиреализуется!
    static int staticField;
    // transient - указывает, что поле не сериализуемо!!!
    // транзиентные поля не должны участвовать ни в equals ни в хешкоже
    transient Sword sword;

}
