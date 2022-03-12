package com.kvvssut.interviews.java.misc;

public class MembersInheritedInChildClass {

    /*
     * A subclass inherits all of the public and protected members of its
     * parent, no matter what package the subclass is in. If the subclass is in
     * the same package as its parent, it also inherits the package-private
     * members of the parent. You can use the inherited members as is, replace
     * them, hide them, or supplement them with new members:
     *
     * 1. The inherited fields and methods can be used directly, just like any
     * other fields and methods.
     *
     * 2. You can declare a field in the subclass with the same name as the one
     * in the superclass, thus hiding it (not recommended).
     *
     * 3. You can write a new instance method in the subclass that has the same
     * signature as the one in the superclass, thus overriding it.
     *
     * 4. You can write a new static method in the subclass that has the same
     * signature as the one in the superclass, thus hiding it.
     *
     * 5. You can write a subclass constructor that invokes the constructor of
     * the superclass, either implicitly or by using the keyword super.
     *
     * 6. A subclass does not inherit the private members of its parent class.
     * However, if the superclass has public or protected methods for accessing
     * its private fields, these can also be used by the subclass.
     *
     * 7. A nested class has access to all the private members of its enclosing
     * class—both fields and methods. Therefore, a public or protected nested
     * class inherited by a subclass has indirect access to all of the private
     * members of the superclass.
     */

}
