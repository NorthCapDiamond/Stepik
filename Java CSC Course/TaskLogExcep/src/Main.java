import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class Main {



    /** Thief – вор, который ворует самые ценные посылки и игнорирует все остальное.
     * Вор принимает в конструкторе переменную int – минимальную стоимость посылки,
     * которую он будет воровать. Также, в данном классе должен присутствовать метод getStolenValue,
     * который возвращает суммарную стоимость всех посылок, которые он своровал. Воровство происходит
     * следующим образом: вместо посылки,
     * которая пришла вору, он отдает новую, такую же, только с нулевой ценностью и содержимым
     * посылки "stones instead of {content}".
     */

    public static class Thief implements MailService {
        private static int stolen = 0;
        private static int price = 0;

        public Thief(int price) {
            this.price = price;
        }

        public int getStolenValue() {
            return stolen;
        }

        @Override
        public Sendable processMail(Sendable mail) {
             if (mail.getClass().equals(MailPackage.class)){
                 MailPackage packages = (MailPackage) mail;
                 Package pack = packages.getContent();
                 if(pack.getPrice() >= price){
                     stolen+=pack.getPrice();
                     String content = "stones instead of "+pack.getContent();
                     Package fakePackage = new Package(content ,0);
                     MailPackage fakeMailPackage = new MailPackage(mail.getFrom(),mail.getTo(),fakePackage);
                     return fakeMailPackage;
                 }
             }
             return mail;
        }
    }



    /** Spy – шпион, который логгирует о всей почтовой переписке, которая проходит через его руки.
     * Объект конструируется от экземпляра Logger, с помощью которого шпион будет сообщать о всех действиях.
     * Он следит только за объектами класса MailMessage и пишет в логгер следующие сообщения (в выражениях нужно
     * заменить части в фигурных скобках на значения полей почты):
     *
     * 1)  Если в качестве отправителя или получателя указан "Austin Powers", то нужно написать в лог сообщение с уровнем WARN: Detected target mail correspondence:
     * from {from} to {to} "{message}"
     *
     * 2) Иначе, необходимо написать в лог сообщение с уровнем INFO: Usual correspondence: from {from} to {to}
     *
     *
     * */
    public static class Spy implements MailService {
        private Logger logger;
        public static final String AUSTIN_POWERS = "Austin Powers";



        public Spy(Logger logger) {
            this.logger = logger;
        }

        @Override
        public Sendable processMail(Sendable mail) {
            if(mail.getClass().equals(MailMessage.class)){
                MailMessage mailMessage = (MailMessage) mail;
                if (mail.getFrom().equals(AUSTIN_POWERS) || mail.getTo().equals(AUSTIN_POWERS)) {
                    String message = String.format("Detected target mail correspondence: from %s to %s \"%s\"", mail.getFrom(),mail.getTo(),mailMessage.getMessage());
                    LogRecord logRecord = new LogRecord(Level.WARNING,message);
                    logger.log(logRecord);
                }
                else{
                    String message = String.format("Usual correspondence: from %s to %s", mailMessage.from, mailMessage.to);
                    LogRecord logRecord = new LogRecord(Level.INFO, message);
                    logger.log(logRecord);
                }
            }
            return mail;
        }
    }

    /** Exceptions*/

    public static class IllegalPackageException extends RuntimeException {
        public IllegalPackageException() {

        }

        public IllegalPackageException (String message) {

        }
    }

    public static class StolenPackageException extends RuntimeException {
        public StolenPackageException() {

        }

        public StolenPackageException (String message) {
        }
    }



    /**
     *  Inspector – Инспектор, который следит за запрещенными и украденными посылками и бьет тревогу в виде исключения,
     *  если была обнаружена подобная посылка. Если он заметил запрещенную посылку с одним из запрещенных содержимым
     *  ("weapons" и "banned substance"), то он бросает IllegalPackageException. Если он находит посылку, состоящую
     *  из камней (содержит слово "stones"), то тревога прозвучит в виде StolenPackageException. Оба исключения вы
     *  должны объявить самостоятельно в виде непроверяемых исключений.
     */

    public static class Inspector implements MailService {
        public static final String WEAPONS = "weapons";
        public static final String BANNED_SUBSTANCE = "banned substance";

        @Override
        public Sendable processMail(Sendable mail) {
            if(mail.getClass().equals(MailPackage.class)){
                MailPackage packages = (MailPackage) mail;
                Package pack = packages.getContent();
                if(pack.getContent().contains(WEAPONS) || pack.getContent().contains(BANNED_SUBSTANCE)){
                    throw new IllegalPackageException();
                }
                if(pack.getContent().contains("stones")){
                    throw new StolenPackageException();
                }
            }
            return mail;
        }
    }





    /** UntrustworthyMailWorker – класс, моделирующий ненадежного работника почты, который вместо того,
     чтобы передать почтовый объект непосредственно в сервис почты, последовательно передает этот объект
     набору третьих лиц, а затем, в конце концов, передает получившийся объект непосредственно экземпляру RealMailService.
     У UntrustworthyMailWorker должен быть конструктор от массива MailService ( результат вызова processMail
     первого элемента массива передается на вход processMail второго элемента, и т. д.) и метод getRealMailService,
     который возвращает ссылку на внутренний экземпляр RealMailService.
     */

    public static class UntrustworthyMailWorker implements MailService {
        private static MailService[] workers;
        private static RealMailService realWorker = new RealMailService();
        RealMailService realMailService = new RealMailService();


        public UntrustworthyMailWorker (MailService[] workers){
            this.workers = workers;
        }

        public MailService getRealMailService() {
            return realMailService;
        }

        @Override
        public Sendable processMail(Sendable mail) {
            for (int i = 0; i < workers.length; i++) {
                mail = workers[i].processMail(mail);
            }
            return realMailService.processMail(mail);
        }
    }




    /**Testing ( full version is created by Stepik )*/


    public static void main(String[] args) {
        Thief thief = new Thief(100);
        MailPackage stolenPackage = new MailPackage("Kroos", "Modrich",new Package("Golden ball",1000));
        stolenPackage = (MailPackage) thief.processMail(stolenPackage);
        Spy spy = new Spy(Logger.getLogger("MailMessage"));
        spy.processMail(new MailMessage("A", "B", "AB"));
        spy.processMail(new MailMessage("Austin Powers", "Unknown", "Top Secret"
        ));
        Inspector inspector = new Inspector();
        //inspector.processMail(new MailPackage("Darknet1","Darknet2", new Package("weapons",10000000)));
        //inspector.processMail(new MailPackage("C", "D", new Package("banned substance",10000000)));
        //inspector.processMail(new MailPackage("Apple.com","customer",new Package("stones instead of Imac 24 inch",0)));
        //inspector.processMail(stolenPackage); 137-140 throws exceptions and shows the work of thief;
        MailService[] workers = new MailService[2];
        workers[0] = thief;
        workers[1] = inspector;
        UntrustworthyMailWorker untrustworthyMailWorker = new UntrustworthyMailWorker(workers);
        stolenPackage = new MailPackage("Kroos", "Modrich",new Package("Golden ball",1000));
        //untrustworthyMailWorker.processMail(stolenPackage);
        UntrustworthyMailWorker untrust = new UntrustworthyMailWorker(new MailService[]{spy, inspector});
        untrust.processMail(new MailMessage("Austin Powers", "Unknown", "Warning"
        ));
        UntrustworthyMailWorker untrustworthyMailWorker1 = new UntrustworthyMailWorker(new MailService[]{spy, inspector});
        //untrustworthyMailWorker1.processMail(new MailPackage("Darknet1","Darknet2", new Package("banned substance",10000000)));

    }
}
