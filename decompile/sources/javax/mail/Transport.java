package javax.mail;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import javax.mail.event.TransportEvent;
import javax.mail.event.TransportListener;

public abstract class Transport extends Service {
    private Vector transportListeners = null;

    public Transport(Session session, URLName uRLName) {
        super(session, uRLName);
    }

    public static void send(Message message) throws MessagingException {
        message.saveChanges();
        send0(message, message.getAllRecipients());
    }

    public static void send(Message message, Address[] addressArr) throws MessagingException {
        message.saveChanges();
        send0(message, addressArr);
    }

    private static void send0(Message message, Address[] addressArr) throws MessagingException {
        Address[] addressArr2;
        Address[] addressArr3;
        Address[] addressArr4;
        Message message2 = message;
        Address[] addressArr5 = addressArr;
        if (addressArr5 == null || addressArr5.length == 0) {
            throw new SendFailedException("No recipient addresses");
        }
        Hashtable hashtable = new Hashtable();
        Vector vector = new Vector();
        Vector vector2 = new Vector();
        Vector vector3 = new Vector();
        for (int i2 = 0; i2 < addressArr5.length; i2++) {
            if (hashtable.containsKey(addressArr5[i2].getType())) {
                ((Vector) hashtable.get(addressArr5[i2].getType())).addElement(addressArr5[i2]);
            } else {
                Vector vector4 = new Vector();
                vector4.addElement(addressArr5[i2]);
                hashtable.put(addressArr5[i2].getType(), vector4);
            }
        }
        int size = hashtable.size();
        if (size != 0) {
            Session defaultInstance = message2.session != null ? message2.session : Session.getDefaultInstance(System.getProperties(), (Authenticator) null);
            if (size == 1) {
                Transport transport = defaultInstance.getTransport(addressArr5[0]);
                try {
                    transport.connect();
                    transport.sendMessage(message2, addressArr5);
                } finally {
                    transport.close();
                }
            } else {
                Enumeration elements = hashtable.elements();
                SendFailedException sendFailedException = null;
                boolean z2 = false;
                while (elements.hasMoreElements()) {
                    Vector vector5 = (Vector) elements.nextElement();
                    int size2 = vector5.size();
                    Address[] addressArr6 = new Address[size2];
                    vector5.copyInto(addressArr6);
                    Transport transport2 = defaultInstance.getTransport(addressArr6[0]);
                    if (transport2 == null) {
                        for (int i3 = 0; i3 < size2; i3++) {
                            vector.addElement(addressArr6[i3]);
                        }
                    } else {
                        try {
                            transport2.connect();
                            transport2.sendMessage(message2, addressArr6);
                            transport2.close();
                        } catch (SendFailedException e2) {
                            if (sendFailedException == null) {
                                sendFailedException = e2;
                            } else {
                                sendFailedException.setNextException(e2);
                            }
                            Address[] invalidAddresses = e2.getInvalidAddresses();
                            if (invalidAddresses != null) {
                                for (Address addElement : invalidAddresses) {
                                    vector.addElement(addElement);
                                }
                            }
                            Address[] validSentAddresses = e2.getValidSentAddresses();
                            if (validSentAddresses != null) {
                                for (Address addElement2 : validSentAddresses) {
                                    vector2.addElement(addElement2);
                                }
                            }
                            Address[] validUnsentAddresses = e2.getValidUnsentAddresses();
                            if (validUnsentAddresses != null) {
                                for (Address addElement3 : validUnsentAddresses) {
                                    vector3.addElement(addElement3);
                                }
                            }
                            transport2.close();
                            z2 = true;
                        } catch (MessagingException e3) {
                            if (sendFailedException == null) {
                                sendFailedException = e3;
                            } else {
                                sendFailedException.setNextException(e3);
                            }
                            transport2.close();
                            z2 = true;
                        } catch (Throwable th) {
                            transport2.close();
                            throw th;
                        }
                    }
                }
                if (z2 || vector.size() != 0 || vector3.size() != 0) {
                    Address[] addressArr7 = null;
                    if (vector2.size() > 0) {
                        Address[] addressArr8 = new Address[vector2.size()];
                        vector2.copyInto(addressArr8);
                        addressArr2 = addressArr8;
                    } else {
                        addressArr2 = addressArr7;
                    }
                    if (vector3.size() > 0) {
                        Address[] addressArr9 = new Address[vector3.size()];
                        vector3.copyInto(addressArr9);
                        addressArr3 = addressArr9;
                    } else {
                        addressArr3 = addressArr7;
                    }
                    if (vector.size() > 0) {
                        Address[] addressArr10 = new Address[vector.size()];
                        vector.copyInto(addressArr10);
                        addressArr4 = addressArr10;
                    } else {
                        addressArr4 = addressArr7;
                    }
                    throw new SendFailedException("Sending failed", sendFailedException, addressArr2, addressArr3, addressArr4);
                }
            }
        } else {
            throw new SendFailedException("No recipient addresses");
        }
    }

    public synchronized void addTransportListener(TransportListener transportListener) {
        if (this.transportListeners == null) {
            this.transportListeners = new Vector();
        }
        this.transportListeners.addElement(transportListener);
    }

    /* access modifiers changed from: protected */
    public void notifyTransportListeners(int i2, Address[] addressArr, Address[] addressArr2, Address[] addressArr3, Message message) {
        if (this.transportListeners != null) {
            queueEvent(new TransportEvent(this, i2, addressArr, addressArr2, addressArr3, message), this.transportListeners);
        }
    }

    public synchronized void removeTransportListener(TransportListener transportListener) {
        Vector vector = this.transportListeners;
        if (vector != null) {
            vector.removeElement(transportListener);
        }
    }

    public abstract void sendMessage(Message message, Address[] addressArr) throws MessagingException;
}
