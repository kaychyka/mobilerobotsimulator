import random

colors = ["red", "blue", "yellow", "black", "purple", "green", "pink", "white", "grey"]
types = ["chair", "table", "trash", "bed", "couch", "TV", "sofa", "gramophone", "desk"]
shapes = ["square", "circle", "pentagon"]

def createRndFile():
    with open('objects.txt', 'w') as f:
        x = input("Enter X size of environment:")
        y = input("Enter Y size of environment:")
        envSize = str(x)+","+str(y)+"\n"
        f.write(envSize)
        #0-closest agent, 1-random agent, 2-different agent        
        for i in range(3):
            c = random.choice(colors)
            s = random.choice(shapes)
            newObj = str(i)+","+c+","+s+","+str(random.randint(0,10))+","+str(random.randint(0,10))+","+str(random.randint(1,4))+"\n"
            print(newObj)
            f.write(newObj)
        f.write('X\n')
        for i in range(13):
            c = random.choice(colors)
            s = random.choice(shapes)
            t = random.choice(types)
            newObj = c+","+s+","+str(random.randint(0,10))+","+str(random.randint(0,10))+","+t+"\n"
            print(newObj)
            f.write(newObj)
        f.write('X\n')
createRndFile()