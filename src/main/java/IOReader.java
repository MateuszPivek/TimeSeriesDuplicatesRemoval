import java.util.LinkedHashMap;

import static java.lang.Thread.sleep;

abstract public class IOReader {

    LinkedHashMap <Integer, Integer> bufferMap;
    int bufferSize;

    public IOReader() {
        this.bufferMap = new LinkedHashMap<Integer, Integer>();
        bufferSize = 100;
    }

    public int getLastRecordKey (){
        return (int) this.bufferMap.keySet().toArray()[this.bufferMap.size() - 1];
    }

    public String getLastRecord(){
        if (this.bufferMap.size() == 0){
            return null;
        }
        int key = getLastRecordKey();
        return String.valueOf(key) + ": " + String.valueOf(this.bufferMap.get(key));
    }

    public LinkedHashMap<Integer, Integer> inputRecordFromString (String input) {
        int lastKey = -1;
        if (this.bufferMap.size() > 0) {
            lastKey = getLastRecordKey();
        }

        String[] keyValue = input.split(":",2);
        int newKey = Integer.parseInt(keyValue[0].trim());

        if(newKey != lastKey) {
            int newValue = Integer.parseInt(keyValue[1].trim());
            int lastValue = -1;

            if (lastKey > 0){
                lastValue = this.bufferMap.get(lastKey);
            }

            if (newValue != lastValue) {
                this.bufferMap.put(newKey,newValue);

                LinkedHashMap<Integer, Integer> outputHashMap = new LinkedHashMap<Integer, Integer>();
                outputHashMap.put(newKey, newValue);
                return outputHashMap;

            }
        }
        return null;
    }

    public void truncateBuffer() {
        if(this.bufferMap.size() > bufferSize) {
            this.bufferMap.remove(this.bufferMap.keySet().toArray()[0]);
        }
    }

    public void listen () throws InterruptedException {
        while (true){
            String newInput = readRecord();
            int lastValue = -1;
            int lastKey = -1;
            if (bufferMap.size() >0) {
                lastKey = getLastRecordKey();
                lastValue = bufferMap.get(lastKey);
            }

            inputRecordFromString(newInput);

            int previousValue = lastValue;
            int previousKey = lastKey;

            lastKey = getLastRecordKey();
            lastValue = bufferMap.get(lastKey);

            if (lastValue != previousValue){
                writeRecord(getLastRecord());
            }

            truncateBuffer();
            sleep(4000);

        }
    }

    abstract String readRecord();
    abstract void writeRecord(String output);




}
