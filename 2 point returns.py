import csv
from coin import coin
class twopointreturns:

    def __init__(self, start, stop, successodds, a, b, strat, n, maxFlips, filename):
        self.start = start
        self.stop = stop
        self.successodds = successodds
        self.a = a
        self.b = b
        self.strat = strat
        self.n = n
        self.maxFlips = maxFlips
        self.filename = filename

    def generator(self):
        with open(filename, mode='w') as output_file:
            self.start = start
            self.stop = stop
            self.successodds = successodds
            self.a = a
            self.b = b
            self.strat = strat
            self.n = n
            self.maxFlips = maxFlips
            self.filename = filename
            # x = strategies
            # y = coin odds
            # z = number of trials
            # a = number of times executed per trial
            success = 0
                #normally 0,50
            coin1 = coin(successodds)
            print(n, maxFlips, successodds, a, b, strat, n, filename)
        for z in range(1, n+1):
            goal = stop
            balance = start
            for c in range(maxFlips):
                if coin1.flip() == 1:
                    balance = balance + (min((strat / 100) * balance, start - stop))*a
                else:
                    balance = balance - (min((strat / 100) * balance, start - stop))*b
                if (balance >= goal):
                    success = success + 1
                    break
            if (z == n):
                successperc = success / n
                success = 0
                stringsuccessperc = str(successperc)
                print("Success Percentage " + stringsuccessperc)


start = input("What is the starting balance?")
start = int(start)
stop = input("What is your ending balance?")
stop = int(stop)
successodds = input("What are the odds of success? (30% - 30")
successodds = int(successodds)
a = input("What is the bet multiplied by on a win? (<0)")
a = float(a)
b = input("What is the bet multiplied by on a loss? (<1)")
b = float(b)
strat = input("What is the fixed percentage betting strategy?")
strat = float(strat)
n = input("How many times do you want to run the simulation on each strategy?")
n=int(n)
maxFlips = input("How many tries before we assume you did not succeed?")
maxFlips = int(maxFlips)
filename = input("What do you want to call the file?")
print("generating...")
test = twopointreturns(start,stop,successodds,a,b, strat, n, maxFlips, filename)

test.generator()
print("Done")