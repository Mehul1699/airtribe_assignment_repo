## Why you used ArrayList instead of array?

We used ArrayList to store Student, Course and Enrollment because it provides a dynamic size.
Unlike arrays, we don't need to specify the size in advance. Plus it provides convenient methods
to store and manage collection of objects.

## Where you used static members and why?

Static variables and methods were used in the _IdGenerator_ class to maintain a single shared counter
for generating IDs. Using static members ensures that all entities access the same counters, 
resulting in unique and consistent ID generation throughout the system.

## Where you used inheritance and what you gained from it?

Inheritance was used by creating a parent class _Person_ to _Student_ class. This reduced code duplication, improved
reusability and made the code easier to maintain and understand because shared functionality was implemented
in one place rather than repeated in multiple classes. Another benefit of inheritance is that the subclass could
reuse the methods of the parent class through _super_ which further reduces redundant code.