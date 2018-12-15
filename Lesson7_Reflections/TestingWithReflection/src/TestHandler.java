import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class TestHandler {

    public static void start(String className) {

        Class<?> clazz = null;
        Object obj = null;
        try {
            clazz = Class.forName(className);
            Constructor<?> ctor = clazz.getConstructor();
            obj = ctor.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


        Method[] methods = clazz.getDeclaredMethods();
        Annotation[] anno;

        HashMap<String, Method> methodHashMap = new HashMap<>();
        ArrayList<Method> methodsArrayList = new ArrayList<>();
        ArrayList<Integer> priorityList = new ArrayList<>();

        for (int i = 0; i < methods.length; i++) {
            anno = methods[i].getDeclaredAnnotations();
            if (anno.length != 0) {
                for (Annotation a : anno) {
                    if (a.toString().split("\\(")[0].equals("@Test")) {
                        methodsArrayList.add(methods[i]);
                        Test aTest = (Test) a;
                        priorityList.add(aTest.priority());
                    } else {
                        if (methodHashMap.containsKey(a.toString())) {
                            throw new RuntimeException("Can't have more than one method with " + a.toString());
                        }
                        methodHashMap.put(a.toString(), methods[i]);
                    }
                }
            }
        }

        methodsArrayList = sortByPriority(methodsArrayList, priorityList);

        try {
            methodHashMap.get("@BeforeSuite()").invoke(obj, null);
            for (int i = 0; i < methodsArrayList.size(); i++) {
                methodsArrayList.get(i).invoke(obj, null);
            }
            methodHashMap.get("@AfterSuite()").invoke(obj, null);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public static void compareInt(int expected, int input) {
        if (expected == input)
            System.out.println("Test OK");
        else
            System.out.println("Test is failed");
    }

    // This method sorts the ArrayList of methods according to the priority of the methods
    public static ArrayList<Method> sortByPriority(ArrayList<Method> list, ArrayList<Integer> priorityList) {

        Comparator<Integer> comparator = (Integer i1, Integer i2) -> {
            if (i1 < i2) {
                return 1;
            } else if (i1.equals(i2)) {
                return 0;
            } else {
                return -1;
            }
        };

        ArrayList<Method> tempList = new ArrayList<>();
        ArrayList<Integer> newPriorList = (ArrayList<Integer>) priorityList.clone();

        newPriorList.sort(comparator);

        int[] order = new int[priorityList.size()];

        for (int i = 0; i < priorityList.size(); i++) {
            for (int j = 0; j < priorityList.size(); j++) {
                if (priorityList.get(i) == (newPriorList.get(j))) {
                    order[j] = i;
                    newPriorList.set(j, -1); // for safety
                    break;
                }
            }
        }

        for (int i = 0; i < priorityList.size(); i++) {
            tempList.add(list.get(order[i]));
        }
        //list = tempList;    //todo somehow it doesn't work!!!
        ArrayList<Method> finalList = tempList;
        priorityList.sort(comparator);
        return finalList;
    }

}
