/*
Рефлексия (от позднелат. reflexio — обращение назад) — это механизм исследования данных о программе во время её выполнения.
Рефлексия позволяет исследовать информацию о полях, методах и конструкторах классов.
*/
package reflection;

    public class MyClass {
        private int number;
        // у поля не getter фунции
        private String name = "default";
        public int getNumber() {
            return number;
        }
        public void setNumber(int number) {
            this.number = number;
        }
        public void setName(String name) {
            this.name = name;
        }
        // метод ошибочно приватный
        private void printData(){
            System.out.println(number + name);
        }
    }
