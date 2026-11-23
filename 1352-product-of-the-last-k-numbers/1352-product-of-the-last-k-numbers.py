class ProductOfNumbers:

    def __init__(self):
        self.pp=[1]

    def add(self, num: int) -> None:
        if num == 0 :
            self.pp = [1]
        else:
            self.pp.append(self.pp[-1]*num)

    def getProduct(self, k: int) -> int:
        if len(self.pp) <= k:
            return 0
        return self.pp[-1] // self.pp[-k-1]


# Your ProductOfNumbers object will be instantiated and called as such:
# obj = ProductOfNumbers()
# obj.add(num)
# param_2 = obj.getProduct(k)