
Q: HashMap vs HashTable?
A: HashMap:
- is un-synchronised
- allows null key and values.
Hashtable:
- is synchronised
- doesn't allow null k or v. 

# Synchronised HashMap
- This is just a HashMap that has an object level lock.
- N.B.: Is thread safe BUT performance isn't as good as a Concurrent HashMap!
- ***Locks entire hashmap***
- Structure:
  - Array of size 15
  - Each bucket/bean can store a Node: Key, Value, Hash, Next
    OR a LinkedList of Nodes.
  - Bucket is the beginning linked list
- At beginning the bucket value is null -> then will try to create and add a node
- ConcurrentHashMap -> ***adds lock only on first bucket NB***
  - 1to1 mapping between array size and # of locks (0-15 -> 16 locks)
  - LOAD FACTOR: 0.75 >> resize operation occurs -> array copied across to bigger array
  - Threshold - more than 8 nodes in a bean - linkedlist converted to a tree (Treeify)

# HashMap
- Not thread safe - only can use in single threaded environments
- Can have single null key & multiple null values
- ConcurrentModificationException

# HashTable
- thread safe - locks whole hashmap
- slow performance - only one thread can act on it at a time
- no null key/values allowed

# Synchronised Map
- thread safe - locks whole hashmap
- Similar to HashTable BUT:
  - Can have single   null key
  - can have multiple null values

# Concurrent Hash Map
- It is a thread-safe without synchronizing the whole map.
- There is no locking at the object level
- Thread safe - faster performance - locks single segment/bucket/bean where Nodes are added(LL)
- Null key/value not allowed - YAY
- READ - multiple threads can read simultaneously
- WRITE - Must add lock to lock segment/bucket/bean
- ConcurrentHashMap doesn’t throw a ConcurrentModificationException if one thread tries to modify it, while another is iterating over it.
- Faster than Hashtable. ConcurrentHashMap is a better choice when there are more reads than writes.

Gate keep:
==========
comp sci fundamentals
- O(n)
- data structures
- program language fluency 14+ testing
- system architecture round
- behavioural - as weighted
- tell me about a time you - star method - leadership
- Ambiguous project
- Leadership - good to great
- V2 - 135$

Osaka:
======
- japan guide com -  international drivers license
