# What is a Variable in Programming?

A **variable** is simply a space in your computer’s memory that’s assigned a name.  
You can imagine it like a labeled box on a shelf where you can store different values.  
(Or if it's easier for you, a list of Links from your Browser where you can see different things)

A **value** is whatever you store inside the variable.  
It could be a number, some text, or a truth value (`True`/`False`).  
That’s what makes variables so flexible: they always hold one specific value,  
and you can change that value at any time.

## In Python :
(and many other languages)

- A value that hasn’t been assigned to a variable only exists for a brief moment (for example, if you just write `"Hello"` without storing it anywhere).
- Only when you write `a = "Hello"`, that text gets stored in memory and can be used later by you (or your program).
- Python automatically “cleans up” unused values for you (this is called the *garbage collector*).

**Important:**  
If you make several variables point to the same value (for example, `b = a`),  
they usually share the same spot in memory, as long as you don’t change anything.  
This can matter when working with complex data types (like lists).

---

## What basic Types of variables exist in Python?

Here are the most important basic variable types in Python:

### Boolean - `bool()`
A truth value: either True or False.  
So terms like `x_is_set`, `x_is_on`, `has_x` or anything you can answer with yes/no will use this type.    
Basically it's a binary value, because it can only be 1 or 0 (on/off).
It's the smallest(RAM) variable type in Python.

```python
is_active = True
sora_is_unicorn = False
```

_Note:_  
Sometimes you read smth. like "Is the X Flag set?" then it's normally a boolean which is meant.  
Flag is set (Means) >> Boolean is True



### Integer - `int()`
This is the next bigger(RAM) variable type.  
It holds a whole number, negative or positive.  
Don't use it for simple 1/0 values. Therefore, use booleans.  
But if you want to save like multiple states, like a permission system,  
you can use integers (but you need a safe check mechanism).  
_Note: There is also the byte var type that could help with this case._


```python
age = 27
money_on_bank = 26367
personal_id = 1234567890
negative_value = -2123
```


### Float - `float()`
A “floating point” number.  
It's always taking more space than an integer.  
It can also be positive or negative.  

**_IMPORTANT NOTE:_**  
_On calculating with floats in python,you can have rounding mistakes!_  
_If you work with **money, always use integers**!_

```python
weight = 72.5
pi = 3.14159265359
bill = -125.99
```

### String - `str()` 
This type saves any **character combination**, or it can also save **single character**.  
It's used to save and manipulate any type of text or chars.  
It can also hold non-printable characters like space, return, tab and more.  
If you work with strings, you need to always have in mind "I can't see all chars!",  
but you still need to test for them (Based on what you do and for safety).

In other languages you have something like `char` but in python the most basic type is string.  

Basically a string is the first `List Type` you will use. Check the Lists Area further below.

```python
first_letter = "a"
name = "Sora"
greeting = "Hello! My name is Sora. I'm 34 years old."

my_space = " "  
# If you know it, you can feel old now :D
```

---

## Saving multiple Elements in one Variable (List Types)
Python speciality (Keep in mind):  
In other languages you can only save one type per list type variable.  
Python fucks on that, so you can save `int, int, int, string, int, int, bool, float`  
So you need to always check on types for list entries!  
(Imagine you try to calculate `int + string` or worse `int + bool` which will result in `int + 1` or `int + 0`)  

> Yes you saw correct. You can even save Lists in Lists.  
> (Above with the String, because string is a List basically)  
> That's called multidimensional List. A List in a List `List[List]` is called 2D List,  
> if we have A,B,C `A[B[C]]` and they are all Lists, then it's a 3D List. And you can go on like this.
> Because Python don't care which Variable Type you place in any List.  
> For how to access this kinda Lists please look at Advanced Topics.

### List - `list()`
*Don't mix up "list type" and "List Types",  
the first is the variable type and the last is the common wording to "group" these types  
(Array, List, Tuple,Set,Frozenset, Dictionary, Map, Hashmap).* 

The most basic type for saving multiple elements in one variable is a `list`.  
You can add as many elements as you want. 

In many languages lists(Also called arrays) are static and can't be changed after initialization.  
(That's the process of setting a value to a var like `x = 15`)  

This type can add, remove and swap elements inside it.  
Many times you want to add elements to a list after something happens, that's your var type for it.  
It can also hold duplications in itself like `25,25,25,25`.  
(See [List Comprehension Table](#list-comprehension-table))

To initialize a List you use `[]` like `[1,2,3]`.  
You can use `Type Casting` with `list()` and use any list type (string, tuple, set, frozenset)  
variable in it. This needs to be used with caution.  
If you type cast on a string, or another list element, all elements inside it will be added as new elements in the list.  
For strings that means `"my name"` results in `["m","y"," ","n","a","m","e"]`

You initialize a list with `[]`.  
Because it's content can change, you can also initialize like this a empty list.  
Like if you want to add elements through a loop.

```python
basic_list = [1,2,3,4,5]
string_list = ["John","is a huge","Banana Fan!","What about Sabrina?","Just no!"]
mixed_list = [1234, "bananas", True, "John", 15.67]

all_lists = [basic_list, string_list, mixed_list]
2d_list_coordinates = [[0,0],[0,1],[1,1],[1,0],[2,0],[2,1],[2,2],[1,2],[0,2]]
```

### Tuple - `tuple()`
This is the most used list type.  
Whenever you call a function which has a return value, most functions return a tuple.  
The reason is simple, it's not changeable after initialization!
It can hold multiple same values.
You initialize a tuple with `()`, can also be used for empty tuples.

Hint:  
That is a critical thing in python, because it is possible to change values OUTSIDE of the methods/functions!  
When you return values, you normally use `copy()` or `deepcopy()`

```python
basic_tuple = (1,2,3,4,5,6)
mixed_tuple = ("booooo", 27, "Elm Street", 3.456)
duplication_tuple = ("John", "Lisa", "John", "Briget", "Lisa")
```

### Set - `set()`
This list type can be changed after initialization,  
but can not hold duplications inside!  
This is commonly used to remove duplications from list or tuple types.  
You initialize a set with `{}`.


```python
basic_set = {"my name is earl", "and you are?", "Giovanni"}
mixed_set = {"Hank", 12, "is a tank", True}

```

How to remove duplications?  
Use type casting and type cast it back into the type you want to have.
```python
duplication_tuple = ("John", "Lisa", "John", "Bridget", "Lisa")
no_duplications = set(duplication_tuple)
output_tuple = tuple(no_duplications)

# Result (First found entry will only be saved, order won't change):
# ("John", "Lisa", "Bridget")
```

### Frozen Set - `frozenset()`
This is special, you can only initialize it with `casting` using `frozenset()` on any list type.  
Like the 3 types above(List, Tuple, Set).  
It's the most unflexible list type possible.  
You can't change it's content, and you can't have duplications.  
That means after initialization with no content, it's useless.
So the use cases are limited. Only use it if you really need it like that.

```python
basic_frozenset = frozenset(["Green", "Blue", "Yellow", "Cyan"])
mixed_frozenset = frozenset(["bananas", "in", "Pjamas", 23, 14, True])
```


### List Comprehension Table
|                                 |                    |                              |
|---------------------------------|--------------------|------------------------------|
|                                 | Content Can Change | Content Can **_NOT_** Change |
| Can Have Duplications           | **List**           | **Tuple**                    |
| Can **_NOT_** have Duplications | **Set**            | **Frozenset**                |

### Special List Type Dictionary - `dict()`
In other Languages referred to as Map or Hashmap many times.  
**Basically you will love this!**  
The reason is simple, it gives you many many possibilities.  
It's basically a super simple `object`, just keep that in mind, don't bother to much about it for now.  

A dictionary is always like a 2 dimensional List.  
You have `Key` and `Value` pairs. Where the key is always a string! Nothing else.  
And the value can be any type (even objects)
```python
my_dict = {"key": "Value"}
people_ages = {"John" : 17, "Mira": 16, "Ben": 16, "Simon":19, "Sabine": 18}

sabine_adress = {"zip": 123456, "street": "Morning Road", "street_no": 17}
sabine = {"age": 18, "female": True, "height": 167, "adress": sabine_adress}
```

They are different accessed than normal list types. You don't have a normal integer index, but a string index!  
Like from above `sabine["age]` will return you `18` which is the value of sabines age key.  
For more details on usage check further belows usage section.

**_Funfact:_**  
With this little element, you can now almost **save all and every complex thing you can think of!**

---

## Special Types of Variables you should at least have heard about

### None type
Basically it's nothing, nada , zero. But less than `0`, `""`, `False`.  
It's an own value. You can specially check for `None` not with `a==None`, but with `a is None`.  
Mostly it's used for placeholders and checks. That's why we short dive into functions,  
to make it easier understandable.

```python
def find_name_in_text(name, text_to_search_in):
    starts_at_index = None
    # Imagine here a super cool function that just saves the position where the name was found(Index)
    # The name can also be found at Index 0! Thats important here, so 0 is a valid value.
    # If not found, the output value is still None
    
   return starts_at_index
   
# Now we call the function, one simple, one with 0 as result and one with not found.

text_a = "hey my name is chriss. i'm old."
text_b = "chriss is my name. i'm here to help!"
text_c = "why is james always messing around?"

found_at_position = find_name_in_text("chriss", text_a) # returns 15
if found_at_position is None:
    print("Sorry your searched name is not found.")
else:
    print(f"Your searched name is found at position {found_at_position}")
    # This will be printed

found_at_position = find_name_in_text("chriss", text_b) # returns 0
if found_at_position is None:
    print("Sorry your searched name is not found.")
else:
    print(f"Your searched name is found at position {found_at_position}")
    # This will be printed
    
found_at_position = find_name_in_text("chriss", text_c) # returns None
if found_at_position is None:
    print("Sorry your searched name is not found.")
    # This will be printed
else:
    print(f"Your searched name is found at position {found_at_position}")


```

Why `None` is so important?  
Because in Python you try to shorten a lot of things to type faster usable code.  
The problem is many checks are like this then:

```python
num = 0
txt = ""
is_on = False

# All this can be checked like this:
if num:
    print(num)

if txt:
    print(txt)

if is_on:
    print(is_on)
    
# But they will all not be printed! Because this check, sees the result in False always.

# Now lets make the user type in some number. They decide for 0, which is valid!
user_input = None
user_input = pseudo_function() # this gets the user input as 0

if user_input:
    print(user_input)
    # THIS WONT BE PRINTED! Because 0 is counted as False! But we want to print also 0 or ""
    
if user_input is not None:
    print(user_input)
    # This will now print also 0 or "" or False

```

### Range
This is a special type that only saves integers.  
It saves `range(start, stop, step)` which takes less RAM than any other list,  
where you save all single steps as a value.  
It's mainly used for the `for loop`, to iterate through it.  
Normally you define a start and a stop integer, then it goes each through with +1.  
If you set a `step` like 5, it will go +5.  
Range can go in positive steps or negative steps(Negative only if you define it in steps!). Bases on start/stop value.  
If `start < stop`, it goes "+", if `start > stop` it goes "-".

Usage:
```python

my_range = range(0, 10)
for i in my_range:
    print(i)  # prints: 0,1,2,3,4,5,6,7,8,9
    
for i in range(25, 15):  # Won't do anything, because 15 is lower and standard step is +1
    print(i) # prints: 

for i in range(25, 15, -1):  
    print(i) # prints: 25,24,23,22,21,20,19,18,17,16
    
for i in range(0, 100, 10):
    print(i)  #  prints: 0,10,20,30,40,50,60,70,80,90

```


### Bytes
Bytes are used to represent raw data. Not strings/chars, not integers, not booleans.  
They store binary data (0001 / 1010 and such), basically as a number.  
This number is not decoded, so it can't be properly displayed.  

**What is this used for?**  
Basically everything like images, sounds and other things you don't save as  
text. Imagine you save mp3 files as text, then you need to "translate"  
them back to smth. you can use in your program.  
Saving it as raw bytes, makes this translation step not needed.

```python
empty_bytes = bytes(4)  
# creates a empty bytes variable with 4 byte.

name_as_bytes = "Sora".encode("UTF-8")  
# Result as print: b'Sora'

ascii_int_as_bytes = bytes([83,111,114,97,95,55,54,55,50])  
# Result as print: b'Sora_7672'
```

This is a common way to use bytes. Here we save normally not printable characters  
in a byte as their counterpart value and convert them with the right decoding.  
These are some common ones, you use for CLI(Command Line Interface) or ASCII Art.

**Note:**  
To save an integer in a byte, you need to give it as a list into the type conversion.  
If you just type an integer in, it will only create this number of empty bytes!  


```python
blocks = dict()

blocks["light_shade"] = bytes([176]).decode('cp437')
blocks["medium_shade"] = bytes([177]).decode('cp437')
blocks["dark_shade"] = bytes([178]).decode('cp437')
blocks["full"] = bytes([219]).decode('cp437')
blocks["half_bottom"] = bytes([220]).decode('cp437')
blocks["half_left"] = bytes([221]).decode('cp437')
blocks["half_right"] = bytes([222]).decode('cp437')
blocks["half_top"] = bytes([223]).decode('cp437')
```

Output(Can look different based on which text reader you use!):
```text
light_shade: ░

medium_shade: ▒

dark_shade: ▓

full: █
half_bottom: ▄
half_left: ▌
half_right: ▐
half_top: ▀
```


### Notes  

> You should at least have heard from it at this point, don't think too much about it.  
> Every variable type is basically a Class, so every variable you define is an Object of a class.
> That means string, int, float, bool, tuple, set, list, dict are all the `Class Names` of the Object 
> you save in RAM.  

> I tell you this, because you can create later your own classes and from them "get" objects,  
> which then are saved as a variable also.  
> **In Short: These are the only types you need to know for now.  
> Later there is an infinite number of types!**

---


## Basic Usage of the Variable Types
> For advanced usage check the [Advanced Topics](../advanced_topics/README.md) !

### Simple variable type usage
[WIP]

### List type variable usage
[WIP]

**[[Back to top Topic]](README.md)**
