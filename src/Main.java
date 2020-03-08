import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        // #1
        /* Прописываем в VMOptions или командной строке -splash:img/flower.jpg */
        // получаем ссылку на экран
        SplashScreen splashScreen = SplashScreen.getSplashScreen();
        // сведения о его графическом контексте
        // Graphics2D g2 = splashScreen.createGraphics();
        // размеры экрана
        // Rectangle bounds = splashScreen.getBounds();

        // g2.setColor(Color.blue);
        // for(int i = 0; i < 100; i++) {
            // g2.fillRect(0,0, bounds.width * i, 20);
            // вызываем метод update для гарантирования обновления рисунка
            // splashScreen.update();
            // Thread.sleep(100);
        //}

        // #2
        /* У рисования прямо на начальном экране имеется следующий существенный недостаток:
        вычислять позиции всех пикселей утомительно, а рисуемый индикатор выполнения обычно не согласуется с собственным индикатором используемой платформы
        Поэтомув самом начале выполнения метода main() лучше заменить начальный экран последующим окном с теми же размерами и содержимым */

        // получаем копию изображения от splashScreen
        final Image img = new ImageIcon(splashScreen.getImageURL()).getImage();
        // Cоздаем фрейм
        final JFrame splashFrame = new JFrame();
        // прорисовываем панель на фрейме с изображением
        final JPanel splashPanel = new JPanel() {
            public void paintComponent(Graphics g) {
                g.drawImage(img,0,0,null);
            }
        };
        // создаем прогресс-бар
        final JProgressBar progressBar = new JProgressBar();
        // отображаем строку прогресса в индикаторе выполнения
        progressBar.setStringPainted(true);

        // добавляем макет на панель BorderLayout();
        splashPanel.setLayout(new BorderLayout());
        // добавляем прогресс-бар с расположениемем NORTH
        splashPanel.add(progressBar, BorderLayout.NORTH);
        // добавляем панель на фрейм
        splashFrame.add(splashPanel);
        // устанавливаем размеры фрейма как размеры splashScreen
        splashFrame.setBounds(splashScreen.getBounds());
        // устанавливаем видимость на true
        splashFrame.setVisible(true);

        try {
            // счетчик до 100
            for(int i = 0; i <= 100; i++) {
                // текст пргресс bar "Загрузка + %"
                progressBar.setString("Loading module " + i);
                // устанавливаем значение пргрузки пргресс бар
                progressBar.setValue(i);
                // перерисовывем панель
                splashPanel.repaint();
                // поток засыпает на 100 millis
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {}

        // устанавливаем видимость на false
        splashFrame.setVisible(false);
    }
}

