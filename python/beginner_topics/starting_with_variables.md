# What is a Variable in Programming?

A **variable** is simply a space in your computer’s memory that’s assigned a name.  
You can imagine it like a labeled box on a shelf where you can store different values.  
(Or if it's easier for you, a list of Links from your Browser where you can see different things)

A **value** is whatever you store inside the variable.  
It could be a number, some text, or a truth value (`True`/`False`).  
That’s what makes variables so flexible: they always hold one specific value,  
and you can change that value at any time.

**Note for your learning speed**:  
You don't need to remember all this directly!  
I designed this document so, you can use it as "Cheat Sheet" for testing around.  
Best is to use it to create some project and check up here if you are unsure about smth.,  
but it's not covering everything you can do with vars. Still easy for CTRL+F this ;)

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

## What Basic Types of Variables Exist in Python?

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
This is the next larger (RAM) variable type.  
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

_IMPORTANT:_  
**Strings are immutable**. You cannot change a string in place.  
Most string methods and operations return a new string as a result.  
It might **look like the original string was changed**, but in reality,  
**a new string** is created and often assigned to the same variable name.

```python
first_letter = "a"
name = "Sora"
greeting = "Hello! My name is Sora. I'm 34 years old."

my_space = " "  
# If you know it, you can feel old now :D
```

---

## Saving Multiple Elements in One Variable (List Types)
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
(See [List Type Comparison Table](#List-Type-Comparison-Table))

To initialize a List you use `[]` like `[1,2,3]`.  
You can use `Type Casting` with `list()` and use any list type (string, tuple, set, frozenset)  
variable in it. This needs to be used with caution.  
If you type cast on a string, or another list element, all elements inside it will be added as new elements in the list.  
For strings that means `"my name"` results in `["m","y"," ","n","a","m","e"]`

You initialize a list with `[]`.  
Because it's content can change, you can also initialize like this an empty list.  
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
That is a critical thing in python, because it is possible to change values **outside** the methods/functions!  
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

**Important:**  
Set and Frozenset don't have always the same order of elements!  
So it can happen if you have lets say a,b,c inside the Set,  
that it get iterated a,b,c or b,a,c or any other combination!  
If you test it, it will be always the same order, because this behaviour  
can happen when a software is changing RAM areas, because of reload of objects  
or heavy load. So you **can't guarantee that Sets work in specific order**!  
Many times it's getting sorted, after adding an element, from lowest to highest value order.


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

# Result: ("John", "Lisa", "Bridget") - or any other order! 
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


### List Type Comparison Table
|                                 |                    |                              |
|---------------------------------|--------------------|------------------------------|
|                                 | Content Can Change | Content Can **_NOT_** Change |
| Can Have Duplications           | **List**           | **Tuple**                    |
| Can **_NOT_** have Duplications | **Set**            | **Frozenset**                |

### Special List Type Dictionary - `dict()`
In other Languages referred to as Map or Hashmap many times.  
**Basically you will love this!**  
The reason is simple, it gives you many many possibilities.  
It's basically a super simple `object`, just keep that in mind, don't worry too much about it for now.

A dictionary is always like a 2-dimensional List.  
You have `Key` and `Value` pairs. 

The key can be any hashable object.  
For now you just need to remember, the key can be string, integer, float or tuple.   
The value can be any variable type.  
Most commonly it's used with `string` as `Key`.
```python
# my_dict = {"key": "Value"}
people_ages = {"John" : 17, "Mira": 16, "Ben": 16, "Simon":19, "Sabine": 18}

sabine_address = {"zip": 123456, "street": "Morning Road", "street_no": 17}
sabine = {"age": 18, "female": True, "height": 167, "address": sabine_address}
```

They are different accessed than normal list types. You don't have a normal integer index, but a string index!  
Like from above `sabine["age]` will return you `18` which is the value of sabine's age key.  
For more details on usage check further belows usage section.

**_Fun fact:_**  
With this little element, you can now almost **save all and every complex thing you can think of!**

---

## Special Types of Variables You Should At Least Have Heard About

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

# Now let’s make the user type in a number. They decide for 0, which is valid!
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

#### Boolean
Most things are described in this topic "[Conditions and Operators](conditions_and_operators.md)",  
because boolean are mostly the result of comparison/conditions.  

The most important thing you need to remember is, that `True` is valued as `1` and `False` as `0`.  
That's why you can do many interesting things with booleans like using it as Index:

```python
answers = ['no', 'yes']

print(answers[False])  # 'no' / Index 0
print(answers[True])   # 'yes' / Index 1
```

Because of that you can also use it for calculations like this:
```python

# interest as dict for calculations
person_x = {
    "likes_cars": True,
    "likes_gaming": False,
    "likes_animals": False,
    "is_family_oriented": True,
    "is_not_smoking": True,
    "is_meat_eater": True,
    "lives_50km_around": True
}

# Calc score
number_elements = 0
dating_score = 0
for interest, value in person_x.items():
    dating_score += int(value)  # True is 1, False is 0
    number_elements += 1

average_dating_score = dating_score / number_elements

# Show scores
print(f"With person x you have a dating score of {dating_score} in ",
f"{number_elements} interests that are scored.")
print(f"Average score: {average_dating_score}")


```

#### Integer
All operations are described in this topic "[Conditions and Operators](conditions_and_operators.md)",  
because it has a lot of operations and uses.

Casting other types into integers is a well-used procedure.  
If you are sure a string **ONLY** includes numbers, you can cast it as below.  
Did you know, that whole number division(`//`) is the same as normal division(`/`)  
followed by a typecasting(`int()`)? It's just removing the floating point numbers...  
If you want real rounding, use math operations.

```python
int("123")     # 123
int(3.99)      # 3
int(True)      # 1
```

You can easily transform numbers to ASCII chars and vice verse:
```python
chr(65)   # 'A'
ord('A')  # 65
```

Many developer forget, that you can directly cast integers into binary, hexadecimal or octal system.  
This can be useful for binary comparison double checks, color systems and unix permissions.  
```python
number = 255
bin(number)   # '0b11111111'
hex(number)   # '0xff'
oct(number)   # '0o377'
```


#### Float
Be aware of rounding errors!  
Floating point calculations many times have rounding errors, you can't prevent!  
Even stuff like `3.4+2.6 = 6.0`  can result in smth. like `6.00000000000000004`.

You can even check if a float is an integer.  
Rounding errors can falsify it.
```python
x = 3.0
y = 3.5
x.is_integer()  # True
y.is_integer()  # False
```

Floats many times are too long or ugly for strings, so you reduce the floating points.  
you do that in a -string with adding `:.nf`, where `n` stands for the count   
of numbers (Replace it with any number between 1-9) behind the floating point.  
You can't do that directly on the float! Only on string outputs of a  float.
```python
print(f"{3.14159:.2f}")  # 3.14
```


You can create a mathematical not a number with using the word "nan" on type conversion to float.  
Same for infinity & negative infinity.   
It's mainly used for more complex math things.  

This does not work with an int!
```python
not_a_number = float("nan")
infinity = float("inf")
not_a_number = float("nan")
```




You can even convert a float into it's counterparts as fraction (`⁵⁄₂`).  
Could be helpful in some math cases, because it returns a tuple of 2 integers.

```python
my_float = 2.5
my_float.as_integer_ratio()  # Returns (5,2)
```


#### String
This one has a ton of usages! That's why we only cover the most basic ones.  
For general list types usage, please check below!  



Strings can be written with `''` or `""`, it doesn't matter, only start sign = stop sign.  
You have 2 ways to use this chars inside a string, without breaking it.  
Either use the opposite char of what you need inside or escape the char to not break the string.  
This also works for other special chars like `\n` for carriage return or `\t` for tab and more.  

```python
string_in_string = "I told Jimmy: 'You are a bad Brother'. And he said: 'No, i'm not!"
another = 'The sign said "Don't poop here!"'

need_both = "He said 'You suck...' and used to do '\"' with his hands..."
# Prints: He said 'You suck...' and used to do '"' with his hands...

more_space = "I love Tab! Here: \t\tit's much spacier like this!"
# Prints: I love Tab! Here: 		it's much spacier like this!

one_liner_with_new_lines = "OMG can you believe that!\nHe really asked me!\nWhat?\nIf i marry him!"
# Prints:
# OMG can you believe that!
# He really asked me!
# What?
# If i marry him!
```

Strings can include any Unicode sign like non latin chars or even emojis.  
Also, you can basically create out of every variable a string.

```python
emojis = "I love 🍕 and 你好!"

my_debug_info = str(3.35672)

```

On every real program the most important string use is the multiline string!  
It's used for documentation also!  
And it's also used as a docstring, therefore it just needs to be at the right position.  
Possible positions: 
- At the start of a file(Module Docstring), shown when importing a file.
- At the start of a function/method(Function/method Docstring), shown when calling a function.
- At the start of a class(Class Docstring), shown when the class is used or an object of that class.

When a string or docstring is inside a file and not used as a var, it's normally a comment / documentation.

```python
"""
This is a multiline string, 
which is not bound to a var,
so its 100% comment only.
"""


my_greeting = """
This is my greeting as multiline string.
It's saved in a variable.
Im Sora.
I love my dog.
"""


def my_function():
    """
    Because i used the right indent here,
    this is a docstring now and shown when
    i scroll in an IDE over the function name.
    """
    pass

    
def my_function():
"""
This is trash.
Because it's not indented right,
it will result in an error.
"""
    pass
```

There are also f-strings (Formatted strings) which can be used to format a string with python code inside it.  
You initialize it with a starting f, followed by 2 double or single quotes: `f""`  
Inside it, you write like a normal string, but use `{}` for placeholder code.  
The usual Python code limitations apply here. You can't declare vars or classes or loops in here.  
There is also the float conversion(see above at float usage).  
It can also be a multiline f-string.  
Also you can directly use other var types without casting them to string before(Like int, float, bool)

For debugging, you can use `{varname=}` to directly print out `varname=value`.

```python
name = sora
age = 34
my_f = f"My name is {name} and i am {age} years old."
# Results in: My name is Sora and i am 34 years old.

make_me_old = f"I am {age +50} years old"  # Adds 50 to the age value, 
# only on string, not integer
# Results in: "I am 84 years old

flower_power = 27382
print(f"{flower_power=}")  # Prints: flower_power=27382
```

Because strings are **immutable** you can't change them directly.  
If you change smth. with a method, you need to either overwrite the old variable name  
or save it as new variable.

They are the first variable type you encounter, that uses **methods**,  
that's why we make a short jump into method usage.

A method is always bound to a specific type of object, imagine humans for it to understand.  
All can breathe, eat, move(and more). If you eat chinese noodles, it will look different then when I do it.  
Basically we perform the same action, but the result(How it looks visually) is different.  
Because I'm much sexier than you :D (Just kidding)

How you call these methods? It's always `var_name.method_name()` where the names can be anything,  
also stuff like `dog.poop()`. We look at an example with a real string var.

```python
my_greeting = "  Hello! How was your day?    "  # To many spaces!
my_clean_greeting = my_greeting.strip()  # strip removes like this " " at the start/end of a string
# Results in "Hello! How was your day?"

# It also works like this, because the string is initialized as soon as it ends:
my_clean_greeting = "  Hello! How was your day?    ".strip()

```

What you do a lot with strings is changing some specifics. Here you see the  most common used  
methods and what they do.
```python
my_string = "hello i'm sora."
print(my_string.upper())  # Makes all caps: "HELLO I'M SORA."
print(my_string.lower())  # All lower case: "hello i'm sora." didnt change because was like this
print(my_string.capitalize())  # Only first letter upper case: "Hello i'm sora." 
print(my_string.title())  # All words start with upper case: "Hello I'm Sora." 

my_word_list =  my_string.split() # Splits on whitespaces to a list: ["hello", "i'm", "sora."]
# You can also split on any other character! Just place it .split(",") like this.

comma_string = ", ".join(my_word_list) # Results in "hello, i'm, sora." as string
# You basically create a string from the elements inside join() and place the string before
# between each element. No starting/ending of that first string part.

my_number_text = str(125)
six_digit_text = my_number_text.zfill(6)  # results in "000125", 
# used to fill up the string to a char count with 0's

```

Also, you can search in strings or count stuff.  
Here are the most common used methods: 

```python
text = "hello world"
print(text.find("world"))  # returns the index position of the search, here 6
# Will return -1 if searchterm is not found.

filename = "image.png"
print(filename.endswith(".png"))  # Returns True, because the last 4 chars are as search term.

filename = "_my_hidden_diary.txt"
print(filename.startswith("_"))  # Returns True, it starts with the chars from the search term.

num = "123"
print(num.isdigit())  # This checks if all chars are numbers from 0-9 (True)

alpha = "abcz"
print(alpha.isalpha())   # This checks if all chars are in a-z (True)


msg = "banana"
print(msg.count("a"))  # Returns the number of the search term occurances (3)
print(msg.count("na"))  # this would return 2

```


### List Type Variable usage

#### General List Type usage
Here we will describe all operations you can use across  
string, list, tuple, set and frozenset.  

They all can be run through a for loop (Details in [Loops and Error Handling](loops_and_error_handling.md)).  
You can check if a value is inside the list and check the list length.
```python
grocery = ["apples", "cola", "bread", "shampoo", "steak"]

for item in grocery:
    print(item)

if "cola" in grocery:
    print("Thats unhealthy")
    
print(f"You have to buy {len(grocery)} things in the supermarket")
```


#### List, Tuple and String
List, Tuple and String are indexed, that means you can access elements in it with `[]`.  
Important to note is,the first element is always index `[0]`.  
You are getting the last element with `[-1]`.  
Basically the last index is `len(list)-1` which you often need to know.  
Not only that, you have variety of possibilities with it. From overriding values(not in String),    
to slicing parts of elements between 2 indexes. 

For advanced slicing you need to remember `[start:stop:step]`, that's the 3 parameters  
you can access inside the brackets. When you only use `start` its index access.  
You can also use stuff like `[:3]` which returns you elements in index 0,1,2.  
The counterpart `[2:]` will only return you all elements from index 2 till end.
Slicing won't change the original list! So you need to save it into a new var.

With `.count()` you get the occurrences of a specific element inside the list.


```python

nums = [1, 2, 2, 3]
print(nums.count(2))    # prints 2 because the number two is found 2 times.
```

#### List and Tuple

On lists and tuple you can search for the first occurrence of an element in it.  
You use `.index()` on the specific list/tuple, where the parameter is the element you search.  
WARNING! If it's not found it throws a `ValueError`!
```python
my_list = [10, 20, 30, 20]
print(my_list.index(20))  # Prints: 1, because the 20 is found on Index 1 first time.

```


#### Only List
Lists have the most extra operations, because they are mutable(changeable).
**WARNING**: All the following **override** the **original** variable! 

So you can add one element in the end of the list with `.append()`  
or a whole list at the end with `.extend()`, where the parameter needs to be  
any list type (list, tuple, set, frozenset).

Then there are methods for changing inside a list. Like `.insert()` where you can add 1 element  
before a specific index. `.insert(5, 23)` will insert before the `index 5` the number `23`.  
Then you can use `.pop()` to either remove the last(highest) indexed element or  
remove an element on a specific index when you use a parameter.

Then we can "find and remove" the first occurrence of an item. We do that with `.remove()`,  
which is used with an element you search for.  
**WARNING**: If the search is not found, it results in a `ValueError`! Probably it's based on `.index()`.


Lastly many times you want to sort your list in specific order, for like finding the highest/lowest values.  
That you do with `.sort()` which sorts from smallest to highest value.
If you need the original order too, you need to save the list in another variable before too.

You can also sort from highest to lowest value like `.sort(reverse=True)`.   
This is called Keyword Argument when you don't just place values, but the keyword in a function call.  
Don't think too much about it, just so you heard it once.

If you just want to reverse the order you have now you use `.reverse()`, which doesn't sort before.


```python
a_list = [17,18,19]
a_list.append(99)  # Adds the 99 in the end of the list
# Result: [17,18,19,99]

my_list = [5,6,7]
my_list.extend((1,2,3))  # adds each element of the tuple in the end of the list.
# Result: [5,6,7,1,2,3]

missing_one = [2,3,4,5,6,7,8,9]
missing_one.insert(0, 1)  # Inserts the number 1 at the start of the list
# Result: [1,2,3,4,5,6,7,8,9]

remove_trash = [5,"6",7]
remove_trash.remove("6")  # Removes the string "6"
# Result: [5,7]

unsorted = [1,5,2,8,9,3,4]
unsorted.sort()  # Sorts and overrides, so no extra saving is needed.
# Result: [1,2,3,4,5,8,9]

unsorted.sort(reverse=True) # Highest to lowest sort
# Result: [9,8,5,4,3,2,1]

card_deck = [7,3,1,4,1,3,5,9,8,2,2,7]
card_deck.reverse()  # Reverse the order without sorting.
# Result: [7,2,2,8,9,5,3,1,4,1,3,7]
```


#### Only Set
Sets are mutable, so there needs to be a way to add new elements, update elements and remove them.
Don't get confused here! Sets have different method names, as list type.  
So make sure you don't threw them together!  
Note: All these methods override the original variable!

With`.add()` you can add a single item to the set.  
`.update()` adds a whole other iterable like list, set,tuple, frozenset into it.  No duplications.  

With`.remove()` you can remove a single item, same as in a list.  
**WARNING**: Also throws a `ValueError` if the element is not inside the Set!


```python
my_set = {1,2,5,7,9}

my_set.add(10)  # Adds this one element to the set
# Results in any order of these: {1,7,9,10,5}

a_set = {5,8}
a_set.update({12})  # adds this one element to the set, 
# it can happen that you have sets with one element, so you see it works.
# Results in any order of these: {5,12,8}

b_set = {11,22}
b_set.update([17,19])  # Adds all elements in the list to the set
# Results in any order of these: {11,19,17,22}
```

#### Set And Frozenset
Because frozensets are immutable(not changeable), all this methods return a new object(set/frozenset)  
so you need to save that in a variable like `my_new_set = old_set.union(second_set)`.  
The output of these methods will always be  a new set or frozenset,  
based on which variable type you have used the method on.

That what you saw above is the `.union()` method, it combines 2 list types.

The `.intersection()` uses the two list types and just returns matching elements,  
no matter the order. Basically like a `INNER JOIN` in SQL.

The `.difference()` uses the two list types and just returns not matching elements,  
no matter the order. Basically like a `OUTER JOIN` in SQL.

`.issubset()` doesn't return a new set / frozenset, but a `boolean`.  
It checks the list in the brackets, if **all of them** are found in the set/frozenset.  
If all are **exactly found**, no matter the order, it returns True, otherwise False.


```python
# POur working sets, some real life example.
math_class = {"Julia B.", "Hendrik S.", "Matthew P.", "Monique P."}
english_class = {"Andy C.", "Hendrik S.", "Jack B.", "Monique P."}
banned_person = {"Jack B."}

class_7d = math_class.union(english_class)  # Combines both classes to one, no duplications
# Result in any order: {"Julia B.", "Hendrik S.", "Matthew P.", "Andy C.", "Jack B.", "Monique P."}

pupil_math_and_english = math_class.intersection(english_class)  # Shows only pupil in both classes
# Result in any order: {"Hendrik S.", "Monique P."}

pupil_only_math_or_only_english = math_class.difference(english_class)  
# Shows pupil which are only in one class
# Result in any order: {"Julia B.", "Matthew P.", "Andy C.", "Jack B."}

# We check if the banned person (yes we use a set) is in the any class listed
# Just to explain how issubset() works.
if banned_person.issubset(math_class):  # Is False
    print(f"{banned_person} is still listed in math class!"
if banned_person.issubset(english_class):  # Is True
    print(f"{banned_person} is still listed in english class!"
```

> **Didactic Tip:**  
> You could just use `in` for a single element,  
> but here we use `.issubset()` with a set of one item  
> to better understand how set methods work!  
> Use `in` for one Element  and `.issubset()` for checking on multiple elements


#### Dict

Dictionaries are mostly accessed by `my_dict[my_key]`,  
where `my_key` can only be a hashable and immutable object.  
This includes types like strings, integers, and tuples (but only if all elements in the tuple are also hashable).

**WARNING:** If the key does not exist, you get a `KeyError`.  
It’s best to check with `if key in my_dict:` before accessing an entry.

To avoid problems with `KeyError`, you can use `.get(key, default=None)`,  
which will return the value for the key if it exists, or `None` (or your own default value) if not.

You can also use `.pop(key, default=None)`, which will remove the key from the dict after returning its value,  
if it does not exist, it will return the default value instead.  
There is also `.popitem()`, which removes the last inserted key-value pair (since Python 3.8).

You can overwrite the value of an entry by simply assigning a new value to its key.

Three main methods you should know:
- `.keys()` – returns a special view object containing all the keys (acts like a list in many ways)
- `.values()` – returns a view of all the values
- `.items()` – returns a view containing all (key, value) pairs as tuples

```python
my_personal_data = {"name": "Unknown", "first_name": "Sora", "age":34, 
    "is_male":True, "has_family":True, "money": 1234.56}
    
sora_money = my_personal_data["money"]  # Just access the key "money" and return its value

# Before accessing a key, check if the key is existing with "in"
if "address" in my_personal_data:
    print(my_personal_data["address"])
else:
    print(f"{my_personal_data["first_name"]} has no address!")
    
# Alternative Sexy Way:
print(my_personal_data.get("address", default=None))  # Prints None because address is not found
    
print(my_personal_data.pop("hsa_family", None))  
# Prints None, because spelling error in key

print(my_personal_data.pop("has_family", None))  
# Prints True and removes the key from the dict

last_added_key_and_value = my_personal_data.popitem()  
# Removes "money" and the value and saves it
```

There's also a handy method called `.setdefault(key, default=None)`,  
which returns the value for a key, or sets it to the default if it doesn't exist.

```python
my_books = {"fear_street": True, "chuckys_revenge":True, "cinderella_hell_version": False, 
    "Hellsing": False, "blood_and_tears": True}
    
if my_books.setdefault("vallhalla_hell", default=False) == True:
    print("Vallhalla Hell i've read already")
# This would check for the key "vallhalla_hell" and because it doesn't exist,
# it creates the key with value False. 

# Counterpart to above:
my_books["vallhalla_hell"] = True
if my_books.setdefault("vallhalla_hell", default=False) == True:
    print("Vallhalla Hell i've read already") 
# Will just print this and don't change anything on the dict.   

```

You can combine two dictionaries into one, or better: update the first with `.update()`.  
**Be aware**: if a **key already exists** in the first dict, its **value will be overwritten**!

```python
a_dict = {"money": 123, "name": "John", "second_name": "Masters"}
b_dict = {"street": "big street 25", "zip": 23456, "money": 11}

a_dict.update(b_dict)

# Now a_dict looks like this:
# {"money": 11, "name": "John", "second_name": "Masters", "street": "big street 25", "zip": 23456}
# "money" got overwritten by the new dict!
```

You can also clear an existing dict from all keys and values with `.clear()`

```python
my_char_counter = {"a":3, "b":17, "k":8, "s":47}
my_char_counter.clear()  # Results in {}
```

You can also create a dictionary from a list (or any iterable) of keys,  
setting the same default value for each key, using `dict.fromkeys(list, value=None)`.

```python
config_names = ["Volume", "Gamma", "Voice-Chat", "Playername"]
my_config = dict.fromkeys(config_names, value=None)
# Results in: {"Volume": None, "Gamma": None, "Voice-Chat": None, "Playername": None}
```

---

### Reminder
You don't need to memorize all of this.

**[[Back to top Topic]](README.md)**